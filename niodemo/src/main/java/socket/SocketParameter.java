package socket;

import java.net.Socket;
import java.net.SocketException;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-4
 * Time: 23:34:08
 * To change this template use File | Settings | File Templates.
 */
public class SocketParameter {
    public static void main(String args[]) throws SocketException {
        Socket socket=new Socket();
        System.out.println("TCP_NODELAY: "+socket.getTcpNoDelay());
        System.out.println("SO_RESURSEADDR: "+socket.getReuseAddress());
        System.out.println("SO_TIMEOUT: "+socket.getSoTimeout());
        System.out.println("SO_LINGER: "+socket.getSoLinger());
        System.out.println("SO_RCVBUF: "+socket.getReceiveBufferSize());
        System.out.println("SO_SNDBUF: "+socket.getSendBufferSize());
        System.out.println("SO_KEEPALIVE: "+socket.getKeepAlive());
    }
}
