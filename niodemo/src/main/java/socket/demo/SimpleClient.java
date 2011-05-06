package socket.demo;

import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-4
 * Time: 8:14:47
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClient {
    public static void main(String args[]){
        try {
            Socket s=new Socket("localhost",8000);
            s.setSoLinger(true,0);
//            s.setSoLinger(true,3600);
            OutputStream os=s.getOutputStream();
            StringBuffer sb=new StringBuffer();
            for (int i=0; i<10; i++){
                sb.append(i+" ");
            }
           os.write(sb.toString().getBytes());
//           os.flush();
           try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.println("start closing the socket");
           long begin=System.currentTimeMillis();
            s.close();
            long end=System.currentTimeMillis();
            System.out.println((end-begin)+" ms");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
