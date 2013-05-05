/*
 * @(#) FileUploadApp.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-24
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class FileUploadApp {
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

    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, FTPException, IOException, FTPIllegalReplyException {
        FTPClient client = new FTPClient();
        client.setSecurity(FTPClient.SECURITY_FTPES);
        client.setSSLSocketFactory(createSSLSocketFactory());
        client.connect("10.123.76.196");
        client.login("test","test");
        InputStream is = FileUploadApp.class.getResourceAsStream("/pdi-ce-src-4.4.0-stable-r17588.zip");
        try {
            client.upload("/home/test/pdi-ce.zip",is,0,0,null);
        } catch (FTPDataTransferException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FTPAbortedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
