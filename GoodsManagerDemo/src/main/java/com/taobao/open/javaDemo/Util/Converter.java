package com.taobao.open.javaDemo.Util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * xml解析转换器
 * @author zhudi
 *
 */
public class Converter {

	/**
	 * 转化一个XML返回为一个对象
	 * 
	 * 如果某一个标签对应的是一个类的话，需要传入映射关系
	 * key=tagName
	 * value = className
	 * 
	 * @param mapping 
	 * @param xml
	 * @return
	 */
	public static Object converter(Map<String,Class<?>> mapping,String xml) { 
       /**
        * XML属性标准采用的是abc_abc_abc的下划线式标准
        * 而java属性采用的是abcAbcAbc的驼峰式标准
        * 所以这边先做个转化
        */
		char[] chars = xml.toCharArray();
		boolean isTag = true;//是否是tag
		StringBuilder xmlResult = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			char c=chars[i];
			if(c=='<'){
				isTag = true;
			}else if(c=='>'){
				isTag = false;
			}
			if(c=='_'&&isTag){
				i++;
				c=(char) (chars[i]-32);
				xmlResult.append(c);
			}else{
				xmlResult.append(c);
			}
		}
		/**
		 * 使用开源项目XStream解析
		 */
        XStream xstream = new XStream(new DomDriver()); 
        DateConverter dateConverter =  new DateConverter();
        //注册日期转换器
        xstream.registerConverter(dateConverter);
        for (Iterator<String> iterator = mapping.keySet().iterator(); iterator.hasNext();) {
        	String key =  iterator.next();
        	 xstream.alias(key, mapping.get(key)); 
		}
        return xstream.fromXML(xmlResult.toString()); 
    } 
	
	/**
	 * 负责日期转化的转换器
	 * @author zhudi
	 *
	 */
	private static class DateConverter extends AbstractSingleValueConverter {

	

		@Override
		@SuppressWarnings("unchecked")
		public boolean canConvert(Class type) {
			while(type!=null){
				if(type.equals(Date.class)){
					return true;
				}else{
					type = type.getSuperclass();
				}
			}
			return false;
		}

		@Override
		public Object fromString(String xml) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				return format.parse(xml);
			} catch (ParseException e) {
				throw new IllegalArgumentException();
			}
		}
		
		
		
	}
	
}
