package socket;

import java.net.*;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 22:22:29
 * To change this template use File | Settings | File Templates.
 */
public class ConnectTester {
    public static void main(String arg[]) throws IOException {
        String msg = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((msg = br.readLine()) != null) {
            if (msg.equals("bye")) break;
            int spaceIndex = msg.indexOf(" ");
            String host = msg.substring(0, spaceIndex);
            String port = msg.substring(spaceIndex+1);
            connect(host, Integer.valueOf(port).intValue());
        }
    }

    public static void connect(String host, int port) {
        SocketAddress remoteAddr = new InetSocketAddress(host, port);
        Socket socket = null;
        String result = "";
        try {
            long begin = System.currentTimeMillis();
            socket = new Socket();
//            socket.bind(new InetSocketAddress(InetAddress.getByName("222.34.5.7"),4000));
            socket.connect(remoteAddr, 1000);
            long end=System.currentTimeMillis();
            result=(end-begin)+" ms";

        } catch (BindException e) {
            result="Local address and port can't be binded.";
        } catch (UnknownHostException e) {
            result="Unknown Host";
        }catch(ConnectException e){
            result="Connection Refused";
        }catch(SocketTimeoutException e){
            result = "TimeOut";
        }catch(IOException e){
            result ="failure";
        }finally{
            if (socket!=null) try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        System.out.println(remoteAddr+" : "+result);
    }
}

