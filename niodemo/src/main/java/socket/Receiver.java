package socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 23:57:38
 * To change this template use File | Settings | File Templates.
 */
public class Receiver {
    private int port = 8000;
    private ServerSocket serverSocket;
    int stopWay = 1;
    final int NATURAL_STOP = 1;
    final int SUDDEN_STOP = 2;
    final int SOCKET_STOP = 3;
    final int INPUT_STOP = 4;
    final int SERVERSOCKET_STOP = 5;

    public Receiver() throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server has been started");
    }

    private BufferedReader getReader(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void receive() throws IOException, InterruptedException {
        Socket socket = null;
        socket = serverSocket.accept();
        socket.setSoLinger(true,0);
        System.out.println("receive a connection");
        BufferedReader br = getReader(socket);
        for (int i = 0; i < 20; i++) {
            String msg = br.readLine();
            System.out.println("receive: " + msg);
//            Thread.sleep(1000);
            if (i == 2) {
                if (stopWay == SUDDEN_STOP) {
                    System.out.println("Stop the server suddently");
                    System.exit(0);
                } else if (stopWay == SOCKET_STOP) {
                    System.out.println("Close the socket suddently and exit");
                    socket.close();
                    break;
                } else if (stopWay == INPUT_STOP) {
                    System.out.println("Close the input stream and exit");
                    socket.shutdownInput();
                    break;
                } else if (stopWay == SERVERSOCKET_STOP) {
                    System.out.println("Close server socket and exit");
                    serverSocket.close();
                    break;
                }
            }
        }//for
        if (stopWay == NATURAL_STOP) {
            serverSocket.close();
        }
        System.out.println("---");
    }

    public static void main(String args[]) throws IOException, InterruptedException {
        Receiver receiver = new Receiver();
        if (args.length > 0) receiver.stopWay = Integer.parseInt(args[0]);
        receiver.receive();

    }
}


