package client;

import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.ClosedChannelException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-1
 * Time: 23:30:03
 * To change this template use File | Settings | File Templates.
 */
public class NonBlockEchoClient {
    private SocketChannel socketChannel;
    private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer receiveBuffer= ByteBuffer.allocate(1024);
    private Charset charset = Charset.forName("UTF-8");
    private Selector selector;

    public NonBlockEchoClient() throws IOException {
         socketChannel= SocketChannel.open();
        InetAddress ia = InetAddress.getLocalHost();
        InetSocketAddress isa=new InetSocketAddress(ia,8000);
        socketChannel.connect(isa);
        socketChannel.configureBlocking(false);
        System.out.println("conect sucessfully");
        selector=Selector.open();
    }

    public static void main(String args[]) throws IOException {
        final NonBlockEchoClient echoClient= new NonBlockEchoClient();
        Thread receive = new  Thread(){
            public void run(){
                try {
                    echoClient.receiveFromUser();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        };

        receive.start();;
        echoClient.talk();

    }

    public void receiveFromUser() throws IOException {
         BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in,charset));
        String msg=null;
        while((msg=localReader.readLine())!=null){
            synchronized(sendBuffer){
                sendBuffer.put(encode(msg+"\r\n",charset));
            }
            if (msg.equals("bye")){
                break;
            }
        }
    }

    public void talk() throws IOException {
        socketChannel.register(selector,SelectionKey.OP_READ| SelectionKey.OP_WRITE);
        while(selector.select()>0){
            Set readykeys=selector.selectedKeys();
            Iterator it=readykeys.iterator();
            while(it.hasNext()){
                SelectionKey key=null;
                key= (SelectionKey) it.next();
                it.remove();
                if (key.isReadable()){
                    receive(key);
                }
                if (key.isWritable()){
                    send(key);
                }
            }
        }
    }

    public void send(SelectionKey key) throws IOException {
        SocketChannel socketChannel= (SocketChannel) key.channel();
        synchronized(sendBuffer){
            sendBuffer.flip();
            socketChannel.write(sendBuffer);
            sendBuffer.compact();
        }
    }

    public void receive(SelectionKey key) throws IOException {
        SocketChannel socketChannel= (SocketChannel) key.channel();
        socketChannel.read(receiveBuffer);
        receiveBuffer.flip();
        String receiveData =decode(receiveBuffer,charset);
        if (receiveData.indexOf("\r\n")==-1)  return;
        String outputData=receiveData.substring(0,receiveData.indexOf("\n")+1);
        System.out.println(outputData);
        if (outputData.equals("echo:bye\r\n")){
            key.cancel();
            socketChannel.close();
            System.out.println("Close connection");
            selector.close();
            System.exit(0);
        }
        ByteBuffer tmp=encode(outputData,charset);
        receiveBuffer.position(tmp.limit());
        receiveBuffer.compact();
    }

    public String decode(ByteBuffer buffer,Charset charset){
        CharBuffer charBuffer=charset.decode(buffer);
        return charBuffer.toString();
    }

    public ByteBuffer encode(String str, Charset charset){
        return charset.encode(str);
    }
}
