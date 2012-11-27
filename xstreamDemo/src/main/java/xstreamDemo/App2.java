/* 
 * Date: 12-11-26
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
package xstreamDemo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张永生(yszhang@travelsky.com), 刘永健(http://my.oschina.net/aiguozhe)
 */
public class App2 {
    public static void main(String[] args) {
        XStream xstream2 = new XStream(new DomDriver());
        xstream2.alias("users", LinkedList.class);
        xstream2.alias("user", User.class);
        xstream2.aliasField("name", User.class, "username");

        List<User> users = (List) xstream2.fromXML("<users>\n" +
                "  <user>\n" +
                "    <name>Archer</name>\n" +
                "    <password>abc123</password>\n" +
                "  </user>\n" +
                "  <user>\n" +
                "    <name>Jack</name>\n" +
                "    <password>abc123</password>\n" +
                "  </user>\n" +
                "</users>");
        for (User user : users) {
            System.out.println(user.username + " " + user.password);
        }
    }
}
