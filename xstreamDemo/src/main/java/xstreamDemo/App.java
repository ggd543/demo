package xstreamDemo;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.DefaultImplementationsMapper;
import com.thoughtworks.xstream.mapper.DefaultMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
//        System.out.println( "Hello World!" );
        Person p = new Person("Liu", "Yongjian");
        Hourse h1 = new Hourse("Guangzhou");
        Hourse h2 = new Hourse("Shanghai");
        h1.person = p;
        h2.person = p;
        List<Hourse> hourses = new ArrayList<Hourse>();
        hourses.add(h1);
        hourses.add(h2);
        p.hourses = hourses;
        PhoneNumber fax = new PhoneNumber(1, "123");
        PhoneNumber phone = new PhoneNumber(2, "456");
        p.fax = fax;
        p.phone = phone;
        XStream xstream = new XStream(new DomDriver()); // does not require XPP3 library
        xstream.alias("hourse", Hourse.class);
        xstream.alias("person", Person.class);
        String xmlstr = xstream.toXML(p);
        System.out.println(xmlstr);

        System.out.println();
        String str = "<person>\n" +
                "  <firstname>Liu</firstname>\n" +
                "  <lastname>Yongjian</lastname>\n" +
                "  <phone>\n" +
                "    <code>2</code>\n" +
                "    <cdma>0101</cdma> "+
                "    <number>456</number>\n" +
                "  </phone>\n" +
                "  <fax>\n" +
                "    <code>1</code>\n" +
                "    <number>123</number>\n" +
                "  </fax>\n" +
                "  <hourses>\n" +
                "    <hourse>\n" +
                "      <addr>Guangzhou</addr>\n" +
                "       <person reference=\"../../..\"/>\n " +
                "      <no>rt</no>"+
                "    </hourse>\n" +
                "    <hourse>\n" +
                "      <addr>Shanghai</addr>\n" +
                "       <person reference=\"../../..\"/>\n " +
                "    </hourse>\n" +
                "  </hourses>\n" +
                "</person>";
        Object obj = xstream.fromXML(str);
        Person person = (Person) obj;
        System.out.println(person.hourses.size());
        Hourse hourse1 = person.hourses.get(0);
        System.out.println("[0]: addr - " + hourse1.addr + " person: " + hourse1.person);

    }
}

