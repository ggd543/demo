package xmlDemo;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

/**
 * User: 刘永健
 * Date: 12-5-1
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class StAXDemo {
    public static void main(String[] args) throws XMLStreamException {
        InputStream is = StAXDemo.class.getResourceAsStream("sample.xml");
        // get the default factory instance
        XMLInputFactory factory = XMLInputFactory.newInstance();
        // configure it to create readers that coalesce adjacent character sections
        factory.setProperty(XMLInputFactory.IS_COALESCING, Boolean.TRUE);
        XMLStreamReader reader = factory.createXMLStreamReader(is);

    }
}
