package xmlDemo;

/**
 * User: 刘永健
 * Date: 12-5-1
 * Time: 上午10:59
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author hongliang.dinghl
 *         SAX文档解析
 */
public class SAXDemo implements XMLDocument {

    public void createXml(OutputStream os) {
        throw new UnsupportedOperationException();
    }

    public void parserXml(InputStream is) {
        SAXParserFactory saxfac = SAXParserFactory.newInstance();

        try {
            SAXParser saxparser = saxfac.newSAXParser();
            saxparser.parse(is, new MySAXHandler());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SAXDemo().parserXml(Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.xml"));
    }
}

class MySAXHandler extends DefaultHandler {

    boolean hasAttribute = false;

    Attributes attributes = null;

    public void startDocument() throws SAXException {
        System.out.println("文档开始打印了");
    }

    public void endDocument() throws SAXException {
        System.out.println("文档打印结束了");
    }

    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("employees")) {
            return;
        }

        if (qName.equals("employee")) {
            System.out.println(qName.trim());
        }

        if (attributes.getLength() > 0) {
            this.attributes = attributes;
            this.hasAttribute = true;
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (hasAttribute && (attributes != null)) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(0)
                        + attributes.getValue(0));
            }
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String str = new String(ch, start, length).trim();
        if (!str.isEmpty())
            System.out.println(str);

    }

}
