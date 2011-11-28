package socket.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-4
 * Time: 8:14:47
 * To change this template use File | Settings | File Templates.
 */
public class SimpleClient {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 8000);
            socket.setSoLinger(true, 0);
//            socket.setSoLinger(true,3600);
            OutputStream os = socket.getOutputStream();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 10; i++) {
                sb.append(i + " ");
            }
            os.write(sb.toString().getBytes());
            os.flush();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            System.out.println("start closing the socket");
            long begin = System.currentTimeMillis();
            os.close();
            socket.close();
            long end = System.currentTimeMillis();
            System.out.println((end - begin) + " ms");
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
