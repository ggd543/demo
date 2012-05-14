package xmlDemo;

/**
 * User: 刘永健
 * Date: 12-5-1
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author hongliang.dinghl
 *         Dom4j 生成XML文档与解析XML文档
 */
public class Dom4jDemo implements XMLDocument {

    public void createXml(OutputStream os) {
        Document document = DocumentHelper.createDocument();
        Element employees = document.addElement("employees");
        Element employee = employees.addElement("employee");
        Element name = employee.addElement("name");
        name.setText("ddvip");
        Element sex = employee.addElement("sex");
        sex.setText("m");
        Element age = employee.addElement("age");
        age.setText("29");
        try {
            XMLWriter xmlWriter = new XMLWriter(os);
            xmlWriter.write(document);
            xmlWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void parserXml(InputStream is) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(is);
            Element employees = document.getRootElement();
            for (Iterator i = employees.elementIterator(); i.hasNext(); ) {
                Element employee = (Element) i.next();
                for (Iterator j = employee.elementIterator(); j.hasNext(); ) {
                    Element node = (Element) j.next();
                    System.out.println(node.getName() + ":" + node.getText());
                }

            }
        } catch (DocumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("dom4j parserXml");
    }
}