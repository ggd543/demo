package mina.demo.timeserver

import java.net.InetSocketAddress
import java.nio.charset.Charset
import org.apache.mina.common.{SimpleByteBufferAllocator, ByteBuffer}
import org.apache.mina.filter.codec.ProtocolCodecFilter
import org.apache.mina.filter.codec.textline.TextLineCodecFactory
import org.apache.mina.filter.LoggingFilter
import org.apache.mina.transport.socket.nio.{SocketAcceptorConfig, SocketAcceptor}

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2010-6-10
 * Time: 23:58:05
 * To change this template use File | Settings | File Templates.
 */

object
MinaTimeServer {
  private val PORT = 9123

  def main(args: Array[String]): Unit = {
    // The following two lines change the default buffer type to 'heap',
    // which yields better performance.
    ByteBuffer.setUseDirectBuffers(false);
    ByteBuffer.setAllocator(new SimpleByteBufferAllocator());

    val acceptor = new SocketAcceptor();

    val cfg = new SocketAcceptorConfig();
    cfg.getFilterChain().addLast("logger", new LoggingFilter());
    cfg.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

    acceptor.bind(new InetSocketAddress(PORT), new TimeServerHandler(), cfg)
    System.out.println("MINA Time server started.");
  }
}