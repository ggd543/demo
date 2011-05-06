package com.taobao.api.internal.parser.xml;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.internal.mapping.Converter;
import com.taobao.api.internal.mapping.Converters;
import com.taobao.api.internal.mapping.Reader;
import com.taobao.api.internal.util.XmlUtil;

/**
 * JSON格式转换器。
 * 
 * @author carver.gu
 * @since 1.0, Apr 11, 2010
 */
public class XmlConverter implements Converter {

	public <T extends TaobaoResponse> T toResponse(String rsp, Class<T> clazz, String api)
			throws ApiException {
		Document xmlDoc = XmlUtil.parseDocument(rsp);
		Element element = xmlDoc.getDocumentElement();
		return getModelFromXML(element, clazz);
	}

	private <T> T getModelFromXML(final Element element, Class<T> clazz) throws ApiException {
		if (element == null)
			return null;

		return Converters.convert(clazz, new Reader() {
			public boolean hasReturnField(Object name) {
				Element childeElement = XmlUtil.getChildElement(element, (String) name);
				boolean result = false;
				if (childeElement != null) {
					result = true;
				}
				return result;
			}

			public Object getPrimitiveObject(Object name) {
				return XmlUtil.getChildAsString(element, (String) name);
			}

			public Object getObject(Object name, Class<?> type) throws ApiException {
				Element childElement = XmlUtil.getChildElement(element, (String) name);
				if (childElement != null) {
					return getModelFromXML(childElement, type);
				} else {
					return null;
				}
			}

			public List<?> getListObjects(Object listName, Object itemName, Class<?> subType)
					throws ApiException {
				List<Object> list = null;
				Element childElement = XmlUtil.getChildElement(element, (String) listName);
				if (childElement != null) {
					list = new ArrayList<Object>();
					NodeList childNodes = childElement.getChildNodes();
					if (childNodes != null) {
						for (int i = 0; i < childNodes.getLength(); i++) {
							Node item = childNodes.item(i);
							if (((String) itemName).equalsIgnoreCase(item.getNodeName())) {
								Object modelFromXML = getModelFromXML((Element) item, subType);
								if (modelFromXML != null)
									list.add(modelFromXML);
							}
						}
					}
				}
				return list;
			}
		});
	}

}
