/*
 * @(#) MappedFileTest.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-03
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedFileTest {


    public static void main(String[] args) {
        URL url = MappedFileTest.class.getResource("/vc.pdf");
        try {

            FileInputStream fis =new FileInputStream(url.getPath());
            int sum=0;
            int n;
            long t1=System.currentTimeMillis();
            try {
                while((n=fis.read())>=0){
                    //sum+=n;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long t=System.currentTimeMillis()-t1;
            System.out.println("sum:"+sum+"  time:"+t);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            BufferedInputStream bis=new BufferedInputStream(new FileInputStream(url.getPath()));
            int sum=0;
            int n;
            long t1=System.currentTimeMillis();
            try {
                while((n=bis.read())>=0){
                    //sum+=n;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            long t=System.currentTimeMillis()-t1;
            System.out.println("sum:"+sum+"  time:"+t);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        MappedByteBuffer buffer=null;
        try {
            buffer=new RandomAccessFile(url.getPath(),"rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1253244);
            int sum=0;
            int n;
            long t1=System.currentTimeMillis();
            for(int i=0;i<1253244;i++){
                //n=0x000000ff&buffer.get(i);
                //sum+=n;
            }
            long t=System.currentTimeMillis()-t1;
            System.out.println("sum:"+sum+"  time:"+t);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

