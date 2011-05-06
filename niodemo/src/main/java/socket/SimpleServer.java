package socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 22:41:22
 * To change this template use File | Settings | File Templates.
 */
public class SimpleServer {
    public static void main(String args[]) throws IOException, InterruptedException {
        ServerSocket serverSocket=new ServerSocket(8000,2);
        Socket socket=serverSocket.accept();
        new SimpleServer().new Server(socket).start();
//        Thread.sleep(360000);
    }

    class Server extends Thread{
        private Socket socket;
        
        public Server(Socket socket){
            this.socket=socket;    
        }

        public void run(){
            try {
                InputStream is=socket.getInputStream();
                byte b=-1;
                while((b=(byte)is.read())!=-1){
                    System.out.println(b);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }finally{
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    
}
