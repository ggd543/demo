package socket;

import java.net.Socket;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 22:10:30
 * To change this template use File | Settings | File Templates.
 */
public class PortScanner {
    public static void main(String args[]){
        String host="localhost";
        if (args.length>0)   host=args[0];
        new PortScanner().scan(host);
    }

    public void scan(String host){
        Socket socket=null;
        for (int port=1; port<=1024; port++ ){
            try {
                socket=new Socket(host,port);
                System.out.println("There is a server on port "+port);
            } catch (IOException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                System.out.println("Can't connect to port "+port);
            }finally{
                if (socket!=null) try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }
}
