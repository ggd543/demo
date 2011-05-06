package com.taobao.api.internal.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 内部使用，此类随时可能变动，外部用户不要调用
 * @author junmu.wj
 *
 */
public class XmlUtil {
	public static Document parseDocument(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource();
			is.setByteStream(new ByteArrayInputStream(in.getBytes("UTF-8")));
			return db.parse(is);
		} catch (ParserConfigurationException ex) {
			throw new RuntimeException(ex);
		} catch (SAXException ex) {
			throw new RuntimeException(ex);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	public static String getChildAsString(Element element, String tag) {
		Element child = getChildElement(element, tag);
		if (child == null)
			return null;
		
		return getStringValue(child);
	}
	public static Element getChildElement(Element element, String tag) {
		NodeList nodes = element.getChildNodes();

		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				Element it = (Element) node;
				if (it.getTagName().equals(tag)) {
					return it;
				}
			}
		}
		
		return null;
	}
	public static String getStringValue(Element element) {
		NodeList nodes = element.getChildNodes();
		if (nodes == null)
			return null;
		
		if (nodes.getLength() == 0)// 如果是空标签，返回空字符串
			return "";
		
		if (nodes.getLength() == 1) {
			Node node = nodes.item(0);
			if (node instanceof Text) {
				Text text = (Text) node;
				return text.getData();
			} else {
				throw new RuntimeException("not support");
			}
		}
		
		throw new RuntimeException("not support");
	}
}
