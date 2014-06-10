package com.ggd543.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class AIOEchoServer {
    private AsynchronousServerSocketChannel server;

    public static void main(String[] args) throws IOException {
        AIOEchoServer aioServer = new AIOEchoServer();
        aioServer.init("localhost", 6025);
    }

    private void init(String host, int port) throws IOException {
        //ChannelGroup用来管理共享资源
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withCachedThreadPool(Executors.newCachedThreadPool(), 10);
        // 打开一个异步socket通道
        server = AsynchronousServerSocketChannel.open(group);
        //通过setOption配置Socket
        server.setOption(StandardSocketOptions.SO_REUSEADDR, true);
        server.setOption(StandardSocketOptions.SO_RCVBUF, 16 * 1024);
        //绑定到指定的主机，端口
        server.bind(new InetSocketAddress(host, port));
        System.out.println("Listening on " + host + ":" + port);
        //输出provider
        System.out.println("Channel Provider : " + server.provider());
        //等待连接，并注册CompletionHandler处理内核完成后的操作。
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            final ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println("waiting....");
                buffer.clear();
                try {
                    //把socket中的数据读取到buffer中
                    result.read(buffer).get();
                    System.out.println(Thread.currentThread()+ " - size: "+buffer.position() + "  Echo " + new String(buffer.array()).trim() + " to " + result+" | attachment:"+attachment);
                    buffer.flip();
                    //把收到的直接返回给客户端
                    result.write(buffer);
                    buffer.flip();
                } catch (InterruptedException | ExecutionException  e) {
                    e.printStackTrace();
                } finally {
                    try {
                        //关闭处理完的socket，并重新调用accept等待新的连接
                        System.out.println("关闭channel");
                        result.close();
                        server.accept(null, this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.print("Server failed...." + exc.getCause());
                server.accept(null, this);
            }

        });

        //因为AIO不会阻塞调用进程，因此必须在主进程阻塞，才能保持进程存活。
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}