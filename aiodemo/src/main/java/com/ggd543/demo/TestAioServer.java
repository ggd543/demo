package com.ggd543.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAioServer {
    private static AtomicInteger recvNum = new AtomicInteger(0);
    private static AtomicInteger sentNum = new AtomicInteger(0);

    private final byte[] resp = {'1','2','3','4','5','6','7','8'};

    private static final int readLen = 8;

    private ByteBuffer[] genBuf() {
        ByteBuffer[] buf = new ByteBuffer[2];
        buf[0] = ByteBuffer.allocate(readLen);
        buf[1] = ByteBuffer.wrap(resp);

        return buf;
    }

    public TestAioServer(int port) throws IOException {

        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));

        serverChannel.accept(genBuf(), new CompletionHandler<AsynchronousSocketChannel, ByteBuffer[]>() {
            public void completed(AsynchronousSocketChannel ch, ByteBuffer[] att) {
                System.out.println("new conn .. ");
                // 接受下一个连接
                serverChannel.accept(genBuf(), this);
                // 处理当前连接
                handle(ch, att);
            }

            public void failed(Throwable exc, ByteBuffer[] att) {
                System.out.print("Server failed...." + exc.getCause());
                serverChannel.accept(null, this);
            }
        });

        System.out.println("Server is listening at : " + port);
    }

    public void handle(final AsynchronousSocketChannel ch, final ByteBuffer[] att) {
        final ByteBuffer dst = att[0];
        ch.read(dst, att, new ReadCompletionHandler(dst, ch));
    }

    private static class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer[]> {
        ByteBuffer dst;
        AsynchronousSocketChannel ch;

        private CompletionHandler<Integer, ByteBuffer[]> writeCompletionHandler = getWriteCompletionHandler();

        public ReadCompletionHandler(ByteBuffer dst, AsynchronousSocketChannel ch) {
            this.dst = dst;
            this.ch = ch;
        }

        @Override
        public void completed(Integer result, ByteBuffer[] attachment) {
            System.out.println("result len = " + result);
            if (dst.position() == dst.capacity()) {   //读完了
                recvNum.incrementAndGet();
                dst.clear();  //为下次读做准备
                System.out.println("read : " + new String(dst.array()));
                ch.write(attachment[1], attachment, writeCompletionHandler);
            } else {
                System.out.println(" 还没读完，继续...");
                ch.read(dst, attachment, new ReadCompletionHandler(dst, ch));
            }
        }

        @Override
        public void failed(Throwable exc, ByteBuffer[] attachment) {
            System.out.println("read failed.");
            exc.printStackTrace();
        }

        public synchronized CompletionHandler<Integer, ByteBuffer[]> getWriteCompletionHandler() {
            if (writeCompletionHandler == null) {
                writeCompletionHandler = new CompletionHandler<Integer, ByteBuffer[]>() {
                    @Override
                    public void completed(Integer result, ByteBuffer[] attachment) {
//                        System.out.println("written len : " + result);
                        //要是没写完，继续
                        if (attachment[1].hasRemaining()) {
                            System.out.println("没写完，继续...");
                            ch.write(attachment[1], attachment, this);
                        } else {//已经写完
                            sentNum.incrementAndGet();
                            attachment[1].rewind();//为下次写做准备
                            //写完了才继续读，生产中不要这么做，此处只是为了简单
                            ch.read(dst, attachment, ReadCompletionHandler.this);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer[] attachment) {
                        System.out.println("write failed.");
                        exc.printStackTrace();
                    }
                };
            }

            return writeCompletionHandler;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 1234;
        new TestAioServer(port);

        Thread.sleep(15000);
        recvNum.set(0);
        sentNum.set(0);
        Thread.sleep(3000000);
        System.out.println(recvNum.get() + ":" + sentNum.get());

        Thread.sleep(30 * 60 * 1000);
    }
}