package socket.echo

import actors.Actor
import java.net.{InetSocketAddress, Socket, ServerSocket}
import java.io.{ByteArrayOutputStream, InputStream, OutputStream}

/**
 * Created by 刘永健
 * User: 刘永健
 * Date: 11-11-3
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */

object SimpleServer {
  def main(args: Array[String]): Unit = {
    val port = if (args.length > 1 && args(0) != null) args(0).toInt else 8080;
    val backlog = if (args.length > 2 && args(1) != null) args(1).toInt else 50;
    new SimpleServer(port, backlog).start()
  }
}

class SimpleServer(val port: Int, val backlog: Int) extends Actor {
  def act() {
    //    val serverSocket = new ServerSocket(port, backlog)
    val serverSocket = new ServerSocket()
    serverSocket.setReuseAddress(true)
    serverSocket.bind(new InetSocketAddress("127.0.0.1", port), backlog)
    println("Create a serverSocket: " + serverSocket)
    var isStop = false
    var socket: Socket = null;
    while (!isStop) {
      socket = serverSocket.accept();
      Actor.actor {
        socket.setSoTimeout(1000)
        val is = socket.getInputStream
        val os = socket.getOutputStream
        val buf = IO.read(is)
        //        os.write(buf)
        //        os.flush()
        val msg = new String(buf, "UTF-8")
        println("Receive " + msg + "of length(" + msg.length + ") from " + socket)
        if ("quit".equalsIgnoreCase(msg)) isStop = true
        socket.close()
      }
    }
    println("Server stop! ")
  }
}

object IO {
  val BYTE_BLOCK_LENGTH = 1024
  /**
   * The input and output stream won't be closed after the method invocation
   *
   * @param is
   * @param os
   */
  def copy(is: InputStream, os: OutputStream): Unit = {
    var buf = new Array[Byte](BYTE_BLOCK_LENGTH)
    var isStop = false
    while (!isStop) {
      val len = is.read(buf, 0, buf.length);
      if (len == -1) isStop = true
      else os.write(buf, 0, len)
    }
  }

  def read(is: InputStream, encoding: String): String = {
    var resBytes = read(is)
    return new String(resBytes, encoding)
  }

  def read(is: InputStream): Array[Byte] = {
    var baos = new ByteArrayOutputStream(BYTE_BLOCK_LENGTH)
    copy(is, baos)
    baos.flush
    var resBytes: Array[Byte] = baos.toByteArray
    is.close
    baos.close
    return resBytes
  }
}

object SimpleClient {
  def main(args: Array[String]): Unit = {
    val ip = if (args.length > 0 && args(0) != null) args(0) else "127.0.0.1";
    val port = if (args.length > 1 && args(1) != null) args(1).toInt else 8080
    val n = if (args.length > 2 && args(2) != null) args(2).toInt else 100
    val isReuseAddr = if (args.length > 3 && args(3) != null) args(3).toBoolean else false

    for (i <- 0 until n) {
      val socket = createSocket(ip, port, isReuseAddr, false)
      val msg = "hello"
      println("send " + msg + " to " + socket)
      val is = socket.getInputStream()
      val os = socket.getOutputStream()
      //      os.write(msg.getBytes("UTF-8"))
      Thread.sleep(5000)
      socket.sendUrgentData(0xFFFF)
      os.flush()
      //      os.close
      //      IO.read(is)
      //      is.close
      socket.close
    }
  }

  private def createSocket(ip: String, port: Int, isReuseAddr: Boolean, isSendUrgentData: Boolean): Socket = {
    val socket = new Socket()
    socket.setReuseAddress(isReuseAddr)
    socket.setOOBInline(isSendUrgentData)
    socket.connect(new InetSocketAddress(ip, port))
    return socket;
  }

}
