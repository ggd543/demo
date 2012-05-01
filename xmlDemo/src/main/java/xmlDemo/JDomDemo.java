package xmlDemo;

import java.io.*;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

/**
 * User: 刘永健
 * Date: 12-5-1
 * Time: 下午12:28
 * To change this template use File | Settings | File Templates.
 */
public class JDomDemo {
    public static void main(String[] args) {
        JDomDemo jdd = new JDomDemo();
        jdd.createXml(System.out);
    }

    public void createXml(OutputStream os) {
        Element root = new Element("employees");
        Document document = new Document(root);
        Element employee = new Element("employee");
        root.addContent(employee);
        Element name = new Element("name");
        name.setText("ddvip");
        employee.addContent(name);
        Element sex = new Element("sex");
        sex.setText("m");
        employee.addContent(sex);
        Element age = new Element("age");
        age.setText("23");
        employee.addContent(age);
        XMLOutputter XMLOut = new XMLOutputter();
        try {
            XMLOut.output(document, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parserXml(InputStream is) {
        SAXBuilder builder = new SAXBuilder(false);
        try {
            Document document = builder.build(is);
            Element employees = document.getRootElement();
            List employeeList = employees.getChildren("employee");
            for (int i = 0; i < employeeList.size(); i++) {
                Element employee = (Element) employeeList.get(i);
                List employeeInfo = employee.getChildren();
                for (int j = 0; j < employeeInfo.size(); j++)
                    System.out.println(((Element) employeeInfo.get(j)).getName() + ":" + ((Element) employeeInfo.get(j)).getValue());
            }
        } catch (JDOMException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
