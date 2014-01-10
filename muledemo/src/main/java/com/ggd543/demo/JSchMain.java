package com.ggd543.demo;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by ggd543 on 14-1-9.
 */
class SFTPConstants{
    public static final String SFTP_REQ_HOST = "host";
    public static final String SFTP_REQ_PORT = "port";
    public static final String SFTP_REQ_USERNAME = "username";
    public static final String SFTP_REQ_PASSWORD = "password";
    public static final int SFTP_DEFAULT_PORT = 22;
    public static final String SFTP_REQ_LOC = "location";
}

public class JSchMain {
    private static final Logger LOG = Logger.getLogger(JSchMain.class.getName());

    Session session = null;
    Channel channel = null;

    public static void main(String[] args) throws URISyntaxException, JSchException {
        JSchMain jm = new JSchMain();
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "192.168.1.102");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "ggd543");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "abc123");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");


        InputStream src = null;
        ChannelSftp chSftp = jm.getChannel(sftpDetails, 60000);
        try {
            src = Thread.currentThread().getContextClassLoader().getResourceAsStream("mule-config.xml");
            String dst = "/home/ggd543/mule-config.xml";
            chSftp.put(src,dst);
        } catch (SftpException e) {
            e.printStackTrace();
        }finally{
            if (src != null){
                try {
                    src.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                jm.closeChannel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ChannelSftp getChannel(Map<String, String> sftpDetails, int timeout) throws JSchException {

        String ftpHost = sftpDetails.get(SFTPConstants.SFTP_REQ_HOST);
        String port = sftpDetails.get(SFTPConstants.SFTP_REQ_PORT);
        String ftpUserName = sftpDetails.get(SFTPConstants.SFTP_REQ_USERNAME);
        String ftpPassword = sftpDetails.get(SFTPConstants.SFTP_REQ_PASSWORD);

        int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }

        JSch jsch = new JSch(); // 创建JSch对象
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort); // 根据用户名，主机ip，端口获取一个Session对象
        LOG.debug("Session created.");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config); // 为Session对象设置properties
        session.setTimeout(timeout); // 设置timeout时间
        session.connect(); // 通过Session建立链接
        LOG.debug("Session connected.");

        LOG.debug("Opening Channel.");
        channel = session.openChannel("sftp"); // 打开SFTP通道
        channel.connect(); // 建立SFTP通道的连接
        LOG.debug("Connected successfully to ftpHost = " + ftpHost + ",as ftpUserName = " + ftpUserName
                + ", returning: " + channel);
        return (ChannelSftp) channel;
    }

    public void closeChannel( ) throws Exception {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }



}
