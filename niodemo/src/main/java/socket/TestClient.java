package socket;

import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 23:30:55
 * To change this template use File | Settings | File Templates.
 */
public class TestClient {
    public static void main(String args[]){
        Socket socket=null;
        try {
            socket=new Socket("localhost",8000);
            OutputStream os=socket.getOutputStream();
            for (int i=0; i<10; i++){
                os.write((byte)i);
            }
            os.flush();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }finally{
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }
}
