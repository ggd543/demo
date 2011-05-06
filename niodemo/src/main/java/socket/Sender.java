package socket;

import java.net.Socket;
import java.net.SocketAddress;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 23:50:35
 * To change this template use File | Settings | File Templates.
 */
public class Sender {
    private String host = "localhost";
    private int port = 8000;
    private Socket socket;
    int stopWay = 1;
    final int NATURAL_STOP = 1;
    final int SUDDEN_STOP = 2;
    final int SOCKET_STOP = 3;
    final int OUTPUT_STOP = 4;

    public Sender() throws IOException {
        socket = new Socket(host, port);
        socket.setTcpNoDelay(true);
//        socket.setReuseAddress(true);
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        Sender sender = new Sender();
        if (args.length > 0) sender.stopWay = Integer.parseInt(args[0]);
        sender.send();
    }

    public PrintWriter getWriter(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream());
    }

    public void send() throws IOException, InterruptedException {
        PrintWriter pw = getWriter(socket);
        for (int i = 0; i < 5; i++) {
            String msg = "hello_" + i;
            pw.println(msg);
            System.out.println("send: "+msg);
            pw.flush();
            Thread.sleep(5000);
            if (i == 2) {
                if (stopWay == SUDDEN_STOP) {
                    System.out.println("stop suddently");
//                    socket.close();
//                    new SocketListenerThread(socket.getLocalPort()).start();
                    break;
//                    System.exit(0);
                } else if (stopWay == SOCKET_STOP) {
                    System.out.println("close socket and stop the programme");
                    socket.close();
                    break;
                } else if (stopWay == OUTPUT_STOP) {
                    socket.shutdownOutput();
                    System.out.println("close the output stream and exit");
                    break;
                }
            }//if
        }//for

        if (stopWay == NATURAL_STOP) {
            socket.close();
        }
    }
}


class SocketListenerThread extends Thread {
    private int port;

    public SocketListenerThread(int port) {
        this.port=port;
    }

    public void run() {
        try {
            ServerSocket ss=new ServerSocket(port);
            System.out.println("Reuse the same port");
            Thread.sleep(3000);
            System.out.println("---------")   ;
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}