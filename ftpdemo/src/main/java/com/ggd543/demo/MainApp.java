/*
 * @(#) MainApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 13-4-12
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPDataTransferListener;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPFile;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import it.sauronsoftware.ftp4j.FTPListParseException;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class MainApp {
   private static class  MyFTPDataTransferListener implements FTPDataTransferListener{
       private String action;
       private int totalBytes;
       private MyFTPDataTransferListener(String action) {
           this.action = action;
           totalBytes = 0;
       }

       public void started() {
           System.out.println(Thread.currentThread()+" start "+action);
       }

       public void transferred(int length) {
           System.out.println(length+" "+action);
       }

       public void completed() {
           System.out.println(Thread.currentThread()+" completed , "+totalBytes+" "+action);
       }

       public void aborted() {
           System.out.println(Thread.currentThread()+" aborted , "+totalBytes+" "+action);
       }

       public void failed() {
           System.out.println(Thread.currentThread()+" failed , "+totalBytes+" "+action);
       }
   }

    private static SSLSocketFactory createSSLSocketFactory() throws NoSuchAlgorithmException, KeyManagementException {
        TrustManager[] trustManagers = {
                new X509TrustManager(){
                    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                        //To change body of implemented methods use File | Settings | File Templates.
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }
        };
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustManagers, new SecureRandom());
        return sslContext.getSocketFactory();
    }


    public static void main(String[] args) {
        FTPClient client = new FTPClient();
        try {
            client.setSecurity(FTPClient.SECURITY_FTPES);
            client.setSSLSocketFactory(createSSLSocketFactory());
            client.connect("10.123.76.196");
            client.setType(FTPClient.TYPE_BINARY);
            System.out.println("isConnect: " + client.isConnected());
            client.login("ftpuser", "ftp");
            System.out.println("isPassive: " + client.isPassive());
            System.out.println("isAuthenticated: " + client.isAuthenticated());
            client.deleteDirectory("xxxx");
            client.createDirectory("xxxx");
//            client.createDirectory("xxxx");
            client.changeDirectory("xxxx");
            System.out.println("current directory: " + client.currentDirectory());
            client.changeDirectoryUp();
            client.upload(getFile("hello.txt"), new MyFTPDataTransferListener("upload"));
            client.upload(getFile("hi.txt"), new MyFTPDataTransferListener("upload") );
            client.download("ListenerManager.java", new File("ListenerManager.java"), new MyFTPDataTransferListener("download"));
            client.download("ListenerManager.java",new File("ListenerManager.java.part"), 1000, new MyFTPDataTransferListener("download"));
            try {

                prints(client.list());
            } catch (FTPListParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FTPIllegalReplyException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FTPException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (KeyManagementException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FTPAbortedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FTPDataTransferException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally{
            try {
                client.disconnect(true);
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (FTPIllegalReplyException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (FTPException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }

    private static void prints(FTPFile[] list) {
        for(FTPFile ftpFile: list){
            System.out.println(ftpFile);
        }
    }

    public static File getFile(String fileName) {
        URL url = MainApp.class.getResource("/"+fileName);
        return new File(url.getPath());
    }
}
