/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-8-12
 * Time: 上午7:12
 */
package pool

import org.apache.commons.pool.impl.GenericObjectPool
import org.apache.commons.pool.PoolableObjectFactory
import java.io.{IOException, OutputStream, InputStream}
import java.net.{SocketException, InetSocketAddress, Socket}
import actors.Debug
;

class SocketPool(config: SocketPool.Config) {
  private val log = Debug
  private val factory = new PoolableObjectFactory() {
    def passivateObject(obj: AnyRef) {
      val socket = obj.asInstanceOf[SocketImpl]
      socket.close()
    }

    def activateObject(obj: AnyRef) {
      val socket = obj.asInstanceOf[SocketImpl]
      socket.open()
    }

    private def isSocketValid(test: => Unit): Boolean = {
      try {
        test
        true
      } catch {
        case _ => false
      }
    }

    def validateObject(obj: AnyRef) = {
      val socket = obj.asInstanceOf[SocketImpl]
      val TestConf = SocketPool.Config.SocketTestMethod
      config.testMethod match {
        case TestConf.URGENT_DATA => isSocketValid(socket.sendUrgentData(0xffff))
        case TestConf.ECHO_API => throw new UnsupportedOperationException(); // TODO
        case TestConf.NONE => true
      }
    }

    def destroyObject(obj: AnyRef) {
      obj.asInstanceOf[SocketImpl].closeSocket()
    }

    def makeObject() = {
      val socket = new SocketImpl()
      socket.setTcpNoDelay(config.isTcpNoDelay)
      socket.setSendBufferSize(config.sendBufferSize)
      socket.setSoTimeout(config.socketTimeout)
      socket.bind(null)
      socket.connect(new InetSocketAddress(config.host, config.port))
      socket
    }
  }

  private val pool = new GenericObjectPool(factory, config)


  /**
   * Returns the maximum number of sockets that can be allocated by the pool
   */
  def maxActive = pool.getMaxActive

  /**
   * Sets the cap on the number of sockets that can be allocated by the pool
   */
  def maxActive_=(n: Int) = pool.setMaxActive(n)

  /**
   * Return the number of Socket currently borrowed from this pool.
   */
  def numActive = pool.getNumActive

  /**
   * Returns the minimum number of sockets allowed in the pool
   */
  def minIdle = pool.getMinIdle

  /**
   * Sets the minimum number of objects allowed in the pool
   */
  def minIdle_=(n: Int) = pool.setMinIdle(n)

  /**
   * Return the number of sockets currently idle in this pool.
   */
  def numIdle = pool.getNumIdle

  /**
   * Close the pool 
   */
  def close() {
    pool.close()
  }

  /**
   *  Clears any sockets, which will close the socket,  sitting idle in the pool by removing them from the
   *  pool
   */
  def clear() {
    pool.clear()
  }

  /**
   * borrow a socket from the pool
   */
  def obtainSocket(): Socket = {
    pool.borrowObject().asInstanceOf[Socket]
  }

  /**
   * Return the socket to the pool
   */
  def returnSocket(socket: Socket): Unit = {
    pool.returnObject(socket)
  }

  /**
   * Remove the socket from the pool and then close it(Release the resources held by the socket)
   */
  def destroySocket(socket: Socket): Unit = {
    pool.invalidateObject(socket)
  }

  /**
   * The socket class that is actually cached by the pool
   */
  private class SocketImpl extends Socket {
    private var isSocketClosed = false
    private var isInputShut = false
    private var isOutputShut = false

    /**
     * Just mark this instance is closed, but not really close
     */
    override def close() {
      isSocketClosed = true
    }

    override def isClosed() = isSocketClosed

    def open() {
      isSocketClosed = false
      isInputShut = false
      isOutputShut = false
    }

    /**
     * Just mark the socket inputStream  shutdown, not really shutdown the stream
     */
    override def shutdownInput() {
      if (isClosed) throw new SocketException("Socket is closed")
      if (!isConnected) throw new SocketException("Socket is not connected")
      if (isInputShutdown) throw new SocketException("Socket input is already shutdown")
      isInputShut = true
    }

    /**
     * Just mark the sockt outputStream shutdown, not really shutdown the stream 
     */
    override def shutdownOutput() {
      if (isClosed) throw new SocketException("Socket is closed")
      if (!isConnected) throw new SocketException("Socket is not connected")
      if (isOutputShutdown) throw new SocketException("Socket output is already shutdown")
      isOutputShut = true
    }

    override def isInputShutdown() = isInputShut

    override def isOutputShutdown() = isOutputShut

    /**
     * Close the socket
     * <p>
     *   This method can only be called by the  pool factory
     */
    def closeSocket() {
      isSocketClosed = false
      super.close();
    }

    /**
     * Mock the socket inputStream, because closing the socket inputStream will result in closing the socket
     */
    override def getInputStream() = {
      val is = super.getInputStream
      new InputStream() {

        override def markSupported() = is.markSupported

        override def reset() {
          is.reset
        }

        override def mark(readlimit: Int) = {
          is.mark(readlimit)
        }

        override def available() = is.available

        override def skip(n: Long) = is.skip(n)

        override def read() = {
          if (isInputShutdown()) -1
          else is.read()
        }

        override def read(b: Array[Byte], off: Int, len: Int) = {
          if (isInputShutdown()) -1
          else is.read(b, off, len)
        }

        override def read(b: Array[Byte]) = read(b, 0, b.length)

        override def close() {
          SocketImpl.this.close();
        }
      }
    }

    /**
     * Mock the socket outputStream, because closing the socket outputStream will result in closing the socket
     */
    override def getOutputStream() = {
      val os = super.getOutputStream;
      new OutputStream() {

        def write(b: Int) {
          val buf = Array(b.toByte)
          write(buf, 0, buf.length)
        }

        override def write(b: Array[Byte]) {
          write(b, 0, b.length)
        }

        override def write(b: Array[Byte], off: Int, len: Int) {
          if (isOutputShutdown()) throw new IOException("The output stream has reached the end")
          else os.write(b, off, len)
        }

        override def flush() {
          os.flush()
        }

        override def close() {
          SocketImpl.this.close()
        }
      }
    }
  }

}

object SocketPool {

  // TODO: Read configuration file
  class Config extends GenericObjectPool.Config {
    testOnBorrow = true
    testOnReturn = true
    var host = "localhost"
    var port = 9898
    var socketTimeout = 60000 // ms
    var sendBufferSize = 1024 // byte
    var tcpDelay = 5000 // ms
    var isTcpNoDelay = true
    var testMethod = Config.SocketTestMethod.URGENT_DATA
  }

  object Config {

    object SocketTestMethod extends Enumeration {
      type SocketTestMethod = Value
      val URGENT_DATA, ECHO_API, NONE = Value
    }

  }

}

