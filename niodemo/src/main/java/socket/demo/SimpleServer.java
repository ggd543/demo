package socket.demo;

import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-3
 * Time: 23:18:45
 * To change this template use File | Settings | File Templates.
 */
public class SimpleServer {
    public static void main(String args[]){
        try {
            ServerSocket serverSocket=new ServerSocket(8000);
            Socket s=serverSocket.accept();
//            Thread.sleep(5000);
            InputStream is=s.getInputStream();
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte []buff=new byte[1024];
            int len=-1;
            while((len=is.read(buff))!=-1){
                baos.write(buff,0,len);
                System.out.println(new String(buff,0,len));
            }
            System.out.println(new String(baos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
