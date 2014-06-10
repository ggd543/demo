package com.ggd543.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 功能描述：
 * <p> 版权所有：优视科技
 * <p> 未经本公司许可，不得以任何方式复制或使用本程序任何部分 <p>
 *
 * @author <a href="mailto:liuyj3@ucweb.com">刘永健</a>
 * @version 1.0.0
 * @since 1.0.0
 * create on: 2014年06月10日
 */
public class TestSocketClient
{
    private static  final int LOOP_TIMES = 2;
    private static final byte[] req = "abcdabcd".getBytes();
    private static final byte[] req1 = {'a','b','c','d'} ;
    private static final byte[] req2= {'a','b','c','d'} ;

    private static final byte[] resp = new byte[8];

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException
    {
        int port = 1234;
//        int port = 6025;
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getByName("localhost"), port));
        final InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        new Thread ()
        {
            public void run()
            {
                long startTime = System.currentTimeMillis();
                int loopTimes = 1;
                for (;; loopTimes++)
                {
                    try
                    {
                        int len = is.read(resp); //不一定会读满，没有数据时会阻塞
                        while ( len < resp.length )
                        {
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            len += is.read(resp, len, resp.length-len);
                        }
                    } catch (IOException e)
                    {
                        e.printStackTrace();
                        break;
                    }
//                    System.out.println(new String(b));
                    System.out.println("loopTimes : " + loopTimes);
                    if (loopTimes == LOOP_TIMES)
                    {
                        System.out.println("time cost : " + (System.currentTimeMillis() - startTime));
                    }
                }
            }
        }.start();

        for (int i=0; i<LOOP_TIMES; i++)
        {
            os.write(req1);
            os.flush();
//            Thread.sleep(1000L);
            os.write(req2);
//            os.write(req);
            os.flush();
            Thread.sleep(1000L);
            System.out.println("written");
        }
    }
}