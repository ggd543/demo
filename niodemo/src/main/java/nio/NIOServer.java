package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {

    /*标识数字*/
    private  int flag = 0;

    /*缓冲区大小*/
    private  int BLOCK = 4096;

    /* 发送数据缓冲区 */
    private ByteBuffer sendbuffer = ByteBuffer.allocate(BLOCK);

    /* 接受数据缓冲区 */
    private ByteBuffer receivebuffer = ByteBuffer.allocate(BLOCK);


    private Selector selector;

    public NIOServer(int port) throws IOException {
        // 打开服务器套接字通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 服务器配置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 检索与此通道关联的服务器套接字
        ServerSocket serverSocket = serverSocketChannel.socket();
        // 进行服务的绑定
        serverSocket.bind(new InetSocketAddress(port));
        // 打开一个默认的selector
        selector = Selector.open();
        // 注册到selector，等待连接
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server Start----8888:");
    }


    // 监听
    private void listen() throws IOException {
        while (true) {
            // 选择一组键，并且相应的通道已经打开
            int selectSize = selector.select();   //在此处阻塞
            // 返回此选择器的已选择键集。
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("select - selectedKeySet's Size: "+selectionKeys.size()+" selectSize: "+selectSize);
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                handleKey(selectionKey);
            }
        }
    }

    // 处理请求
    private void handleKey(SelectionKey selectionKey) throws IOException {
        // 接受请求
        ServerSocketChannel server = null;
        SocketChannel client = null;
        String receiveText;
        String sendText;
        int count=0;
        // 测试此键的通道是否已准备好接受新的套接字连接。
        if (selectionKey.isAcceptable()) {
            System.out.println("acceptable ");
            // 返回为之创建此键的通道。
            server = (ServerSocketChannel) selectionKey.channel();
            // 接受到此通道套接字的连接。
            // 此方法返回的套接字通道（如果有）将处于阻塞模式。
            client = server.accept();
            // 配置为非阻塞
            client.configureBlocking(false);
            // 注册到selector，等待连接
            client.register(selector, SelectionKey.OP_READ| SelectionKey.OP_WRITE);
        }
        if (selectionKey.isReadable()) {
            System.out.println("isReadble ");
            // 返回为之创建此键的通道。
            //处理读数据，每个channel的数据需要进行累积，业务逻辑应在另外的线程中处理
            client = (SocketChannel) selectionKey.channel();
            //将缓冲区清空以备下次读取
            receivebuffer.clear();
            //读取服务器发送来的数据到缓冲区中
            count = client.read(receivebuffer);
            if (count > 0) {
                receiveText = new String( receivebuffer.array(),0,count);
                System.out.println("client to server :"+receiveText);
                client.register(selector, SelectionKey.OP_WRITE);
            }
        }

        if (selectionKey.isWritable()) {
            System.out.println("isWritable");
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //处理写数据，也可以放在另外的线程中
            //将缓冲区清空以备下次写入
            sendbuffer.clear();
            // 返回为之创建此键的通道。
            client = (SocketChannel) selectionKey.channel();
            sendText="message from server--" + flag++;
            //向缓冲区中输入数据
            sendbuffer.put(sendText.getBytes());
            //将缓冲区各标志复位,因为向里面put了数据标志被改变要想从中读取数据发向服务器,就要复位
            sendbuffer.flip();
            //输出到通道
            while(sendbuffer.hasRemaining()){
                int writtenLen = client.write(sendbuffer); //   每次写多少不能保证
                System.out.println("writtenLen = "+writtenLen);
            }

            System.out.println("server to client :"+sendText);
            //改成注册读事件，否则会有无数写事件被触发，因为只要是IO处于可写状态就会触发
            client.register(selector, SelectionKey.OP_READ);
        }
        System.out.println(" socketChannel :"+client+" hashcode:"+client.hashCode());
    }

    /**
     * @param args
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        int port = 8888;
        NIOServer server = new NIOServer(port);
        server.listen();
    }
}