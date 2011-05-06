package nonblock;

import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 2009-10-31
 * Time: 14:24:27
 * To change this template use File | Settings | File Templates.
 */
public class EchoServer {
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private int port = 8000;
    private Charset charset = Charset.forName("UTF-8");

    public EchoServer() throws IOException {
        selector = Selector.open();
        serverSocketChannel=ServerSocketChannel.open();
        serverSocketChannel.socket().setReuseAddress(true);   //
        serverSocketChannel.configureBlocking(false);   // Set this serverSockerChannel unblocking
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        System.out.println("The server is started. Server' IP: "+serverSocketChannel.socket().getInetAddress());
    }

    public void service() throws IOException {
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {  // Will block until an event occurs
            Set readyKeys = selector.selectedKeys();  // Get all the SelectionKey that has been captured.
            Iterator it = readyKeys.iterator();
            while (it.hasNext()) {
                SelectionKey key = null;
                try {
                    key = (SelectionKey) it.next();
                    it.remove();
                    if (key.isAcceptable()) { // A SelectionKey.OP_ACCEPT event occurs
                        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = ssc.accept();   // acquire the socketChannel
                        System.out.println("Receive a connection from client, " +
                                socketChannel.socket().getInetAddress() + ":" + socketChannel.socket().getPort());  //print a message
                        socketChannel.configureBlocking(false);   // make this socketChannel unblocking
                        ByteBuffer buffer = ByteBuffer.allocate(1024);   // create a buffer as an attachment
                        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE, buffer);
                    }
                    if (key.isReadable()) {  // A SelectionKey.OP_READ event occurs
                        receive(key);
                    }
                    if (key.isWritable()) {
//                        System.out.println("isWritable");
                        send(key);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    try {
                        if (key != null) {
                            key.cancel();
                            key.channel().close();
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    public void send(SelectionKey key) throws IOException {
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        SocketChannel socketChannel = (SocketChannel) key.channel();
        buffer.flip();
        String data = decode(buffer);
        if (data.indexOf("\r\n") == -1) return;
        String outputData = data.substring(0, data.indexOf("\n") + 1);
        System.out.print(outputData);
        ByteBuffer outputBuffer=encode("echo: "+outputData);
        while(outputBuffer.hasRemaining())
            socketChannel.write(outputBuffer);
        ByteBuffer tmp=encode(outputData);
        buffer.position(tmp.limit());
        buffer.compact();

        if (outputData.equals("bye\r\n")){
            key.cancel();
            socketChannel.close();
            System.out.println("close the connection");
        }
    }

    public void receive(SelectionKey key) throws IOException {
        ByteBuffer buffer= (ByteBuffer) key.attachment();
        SocketChannel socketChannel= (SocketChannel) key.channel();
        ByteBuffer readBuffer=ByteBuffer.allocate(32);
        socketChannel.read(readBuffer);
        readBuffer.flip();
        buffer.limit(buffer.capacity());
        buffer.put(readBuffer);
    }

    public String decode(ByteBuffer buffer){
        CharBuffer charBuffer=charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str){
        return charset.encode(str);
    }

    public static void main(String args[]) throws IOException {
        EchoServer server=new EchoServer();
        server.service();
    }
}
