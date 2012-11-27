package xstreamDemo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        List<User> userList = new LinkedList<User>();
        userList.add(new User("Archer","abc123"));
        userList.add(new User("Jack","abc123"));
//        XStream xstream = new XStream(new Dom4JDriver());
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("users",LinkedList.class);
        xstream.autodetectAnnotations(true);
//        xstream.alias("user", User.class);
//        xstream.aliasField("name", User.class, "username"); // 无效果
        System.out.println(xstream.toXML(userList));


    }
}