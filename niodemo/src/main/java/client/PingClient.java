package client;

import java.net.InetSocketAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.channels.SocketChannel;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.ClosedChannelException;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 2009-11-2
 * Time: 11:09:53
 * To change this template use File | Settings | File Templates.
 */
public class PingClient {
    boolean shutdown = false;

    class Printer extends Thread {
        public Printer(){
            setDaemon(true);
        }
        public void run(){
            printFinishedTarget();
        }
    }

    class Connector extends Thread {
        public void run() {
            while(!shutdown){
                registerTargets();
                try {
                    if (selector.select()>0){
                       processSelectedKeys();
                    }
                } catch (IOException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    public void registerTargets(){
        // Get a target from targets list and register the SelectionKey.OP_CONNECT event to selector.
        // This method will be called by Connector thread
        synchronized(targets){
            while(targets.size()>0){
                Target target= (Target) targets.removeFirst();
                try {
                    target.socketChannel.register(selector,SelectionKey.OP_CONNECT,target);
                } catch (ClosedChannelException e) {
//                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    try {
                        target.socketChannel.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }
                    target.failure=e;
                    addFinishedTarget(target);
                }
            }
        }
    }

    /**
     * This class represent a task.
     */
    class Target {
        InetSocketAddress address;
        SocketChannel socketChannel;
        Exception failure;
        long connectStart;   // The time that starts to connect.
        long connectFinish;  // The time that finishs connecting successfully
        boolean shown = false;  // indicate that whether the target has been printed 


        Target(String host) {
            try {
                address = new InetSocketAddress(InetAddress.getByName(host), 80);
            } catch (UnknownHostException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                failure = e;
            }
        }

        void show() {
            String result;
            if (connectFinish != 0) {
                result = Long.toString(connectFinish - connectStart) + " ms";
            } else if (failure != null) {
                result = failure.toString();
            } else {
                result = "Time out.";
            }
            System.out.println(address + " : " + result);
            shown = true;
        }
    }

    private Selector selector;
    private LinkedList targets = new LinkedList();          // The list that stores the newly created target
    private LinkedList finishedTargets = new LinkedList();  // The list that stores the target needed to be printed

    public PingClient() throws IOException {
        selector = Selector.open();
        Connector connector = new Connector();
        Printer printer = new Printer();
        connector.start();
        printer.start();
        receiveTarget();
    }

    public void receiveTarget() {
        // receive the domain names and put them into targets list. This methd will be called by main thread
        BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        try {
            while ((msg = localReader.readLine()) != null) {
                if (!msg.equals("bye")){
                    Target target=new Target(msg);
                    addTarget(target);
                }else{
                    shutdown=true;
                    selector.wakeup();   // Let Connector thread return from the method select()
                    break;
                }
           }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void addTarget(Target target) {
        // Put a target to the targets list,  this method will be called by the main thread
        SocketChannel socketChannel = null;
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(target.address);
            target.socketChannel = socketChannel;
            target.connectStart = System.currentTimeMillis();
            synchronized (targets) {
                targets.add(target);
            }
            selector.wakeup();
        } catch (IOException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
            target.failure = e;
            addFinishedTarget(target);
        }

    }

    public void addFinishedTarget(Target target) {
        // Add a target into the finishedTargets. This method will be called by Main Thread and Connector thread
        synchronized (finishedTargets) {
            finishedTargets.notify();
            finishedTargets.add(target);
        }
    }

    public void printFinishedTarget() {
        // Print all the target's message from the finishedTargets list. The metod will be called by Printer thread.
        try {
            for (; ;) {
                Target target = null;
                synchronized (finishedTargets) {
                    while (finishedTargets.size() == 0) {
                        finishedTargets.wait();
                    }//while
                    target= (Target) finishedTargets.removeFirst();
                    target.show();
                }
            }//for
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void processSelectedKeys() throws IOException {
        // tackle the SelectionKey.OP_CONNECT event. This method will be called by Connector thread
        for (Iterator it = selector.selectedKeys().iterator(); it.hasNext();) {
            SelectionKey selectionKey = (SelectionKey) it.next();
            it.remove();
            Target target = (Target) selectionKey.attachment();
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            try {
                if (socketChannel.finishConnect()) {
                    selectionKey.cancel();
                    target.connectFinish = System.currentTimeMillis();
                    socketChannel.close();
                    addFinishedTarget(target);
                }
            } catch (IOException e) {
//                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                socketChannel.close();
                target.failure = e;
                addFinishedTarget(target);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new PingClient();
    }

}
