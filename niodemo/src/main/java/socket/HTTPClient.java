package socket;


import java.net.Socket;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-11-2
 * Time: 22:48:27
 * To change this template use File | Settings | File Templates.
 */
public class HTTPClient {
//    private String host = "www.baidu.com";
//    private String host = "www.javathinker.org";
    private String host = "www.google.com";
    private int port = 80;
    private Socket socket;

    public void createSocket() throws IOException {
        socket = new Socket(host, port);
    }

    public void communicate() throws IOException {
        StringBuffer sb = new StringBuffer("GET " + "/index.jsp " + "HTTP/1.1\r\n");
//        StringBuffer sb = new StringBuffer("GET " + "/index.html " + "HTTP/1.1\r\n");
        sb.append("Host: " + host+"\r\n");
        sb.append("Accept: */*\r\n");
        sb.append("Accept-Language: zh-cn\r\n");
        sb.append("Accept-Encoding: gzip,deflate\r\n");
        sb.append("User-Agent: Mozilla/4.0(compatible; MSIE 6.0; Windows NT 5.0)\r\n");
        sb.append("Connection: Keep-Alive\r\n\r\n");
        
        // send a http request
        OutputStream os = socket.getOutputStream();
        os.write(sb.toString().getBytes());

        System.out.println("-----------------------");
        System.out.println(socket);
        System.out.println("-----------------------");
        // receive a http response
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int len = -1;
        while ((len = is.read(buff)) != -1) {
            buffer.write(buff, 0, len);
        }
        System.out.println(new String(buffer.toByteArray()));
        socket.close();
    }

    public static void main(String args[]) throws IOException {
        HTTPClient client=new HTTPClient();
        client.createSocket();
        client.communicate();
    }
}
