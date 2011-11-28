/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-8-12
 * Time: 上午7:12
 */
package pool

import org.apache.commons.pool.impl.GenericObjectPool
import org.apache.commons.pool.PoolableObjectFactory
 
import java.net.{InetSocketAddress, Socket}
import java.io.InputStream;
class SocketPool(config: SocketPool.Config){

  private val factory = new PoolableObjectFactory(){
    def passivateObject(obj: AnyRef) {}

    def activateObject(obj: AnyRef) {}

    def validateObject(obj: AnyRef) = false

    def destroyObject(obj: AnyRef) {}

    def makeObject() =  {
      val socket = new SocketImpl()
      socket.setKeepAlive(true)
      socket.setReuseAddress(true)
 
      socket.bind(null)
      socket.connect(new InetSocketAddress(config.host, config.port))
      socket
    }
  }
 
  private val pool = new GenericObjectPool()

  def obtainSocket(): Socket = {
    //TODO
  }


  def returnSocket(socket: Socket):Unit={
    //TODO
  }

  def destrySocket(socket: Socket):Unit={
    //TODO
  }

  private class SocketImpl extends Socket{
    /**
     * Return a socket to pool 
     */
    def close()={

    }

    /**
     * Close the socket 
     */
    def closeSocket(){
      
    }

    def getInputStream() ={
      val is = super.getInputStream
      new InputStream(){

        override def markSupported() = is.markSupported

        override def reset() { is.reset}

        override def mark(readlimit: Int) = { is.mark(readlimit)}
 
        override def available() = is.available

        override def skip(n: Long) = is.skip(n)
  
        override def read(b: Array[Byte], off: Int, len: Int) = is.read(b,off,len)

        override def read(b: Array[Byte]) = is.read(b)

        def close(){
         // do nothing
        }
      }
    }
    
    
  }
  
}

object SocketPool{
  // Read configuration file
  class Config extends GenericObjectPool.Config{
     var host ="localhost"
     var port=9898

  }
 
}

