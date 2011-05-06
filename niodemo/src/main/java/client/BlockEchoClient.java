package client;

import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-1
 * Time: 22:39:53
 * To change this template use File | Settings | File Templates.
 */
public class BlockEchoClient {
    private SocketChannel socketChannel =null;

    public BlockEchoClient() throws IOException {
        socketChannel = SocketChannel.open();
        InetAddress ia=InetAddress.getLocalHost();
        InetSocketAddress isa=new InetSocketAddress(ia,8000);
        socketChannel.connect(isa);   // connect to server in blocking mode
        System.out.println("connect successfully");
    }

    public static void main(String args[]) throws IOException {
        new BlockEchoClient().talk();
    }

    private PrintWriter getWriter(Socket socket, Charset charset) throws IOException {
        Writer os=new OutputStreamWriter(socket.getOutputStream(),charset);
        return new PrintWriter(os,true);
    }

    private PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(),true);
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        InputStream is=socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is));
    }

    private BufferedReader getReader(Socket socket, Charset charset) throws IOException {
        InputStream is=socket.getInputStream();
        return new BufferedReader(new InputStreamReader(is,charset));
    }

    public void talk() throws IOException {
        Charset charset=Charset.forName("UTF-8");
        BufferedReader br=getReader(socketChannel.socket(),charset);
        PrintWriter pw=getWriter(socketChannel.socket(),charset);
        BufferedReader localReader =new BufferedReader(new InputStreamReader(System.in));
        String msg=null;
        while((msg=localReader.readLine())!=null){
            pw.println(msg);
            System.out.println(br.readLine());
            if (msg.equals("bye")){
                break;
            }
        }
        socketChannel.close();
    }

    

}
