package com.ggd543.soap;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-9-13
 * Time: 上午7:57
 * To change this template use File | Settings | File Templates.
 */
public class HelloClient {
    public static void main(String[] args) {
        String name ="Guest";
        if (args.length != 0 ) name= args[0];
        String endpoint = "http://localhost:8080/axis/services/helloservice";

        Service service = new Service();
        
    }
}
