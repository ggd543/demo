package mina.demo.timeserver

import java.lang.Throwable
import java.util.Date
import org.apache.mina.transport.socket.nio.SocketSessionConfig
import org.apache.mina.common._

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-6-13
 * Time: 8:56:30
 * To change this template use File | Settings | File Templates.
 */

class TimeServerHandler extends IoHandlerAdapter {
  override def messageSent(session: IoSession, message: Any) = {
    println("Send a message: " + message)
  }

  override def messageReceived(session: IoSession, msg: Any) = {
    val str = msg.toString();
    println(msg.isInstanceOf[ByteBuffer])
    if ("quit".equalsIgnoreCase(str)) {
      session.close();
    } else {
      val date = new Date();
      val buf = date.toString().getBytes("utf-8")
      session.write(date.toString());
      //      session.write(ByteBuffer.wrap(buf, 0 , buf.size))
      println("Message written...");
    }
  }

  override def exceptionCaught(session: IoSession, cause: Throwable) = {
    cause.printStackTrace();
    println("----------------------")
    session.close();
  }

  override def sessionIdle(session: IoSession, status: IdleStatus) = {
    println("yes . idle ")
  }

  override def sessionClosed(session: IoSession) = {}

  override def sessionOpened(session: IoSession) = {}

  override def sessionCreated(session: IoSession) = {
    println("Session created...");
    if (session.getTransportType() == TransportType.SOCKET) {
      (session.getConfig().asInstanceOf[SocketSessionConfig]).setReceiveBufferSize(2048);
      session.setIdleTime(IdleStatus.BOTH_IDLE, 10);
    }

  }
}