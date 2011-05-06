package com.taobao.open.javaDemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final static Properties p = new Properties();

    static {
        try {
            InputStream is = Config.class.getClassLoader().getResourceAsStream("/config.properties");
//            System.out.println("is "+ is);
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public final static String appKey = p.getProperty("appKey", "test");
    public final static String appSecret = p.getProperty("appSecret", "test");
    public final static String callBackUrl = p.getProperty("callBackUrl", "http://localhost:8080/gmd/index.html");  //回调url
    public final static String SANDBOX_URL = p.getProperty("SANDBOX_URL", "http://gw.api.tbsandbox.com/router/rest"); //后面接api
    public final static String GET_SESSION_URL = p.getProperty("GET_SESSION_URL", "http://container.api.tbsandbox.com/container"); // 用来获取authCode和sessionCode
}