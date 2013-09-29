package com.ggd543.demo.xml;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-27
 * Time: 下午8:17
 * To change this template use File | Settings | File Templates.
 */
public class MappingMode {
    private static String outputXmlFileName = "out.xml";

    public static void main(String[] args) throws IOException, MappingException, MarshalException, ValidationException {
        // Load Mapping
        Mapping mapping = new Mapping();
        URL url = MappingMode.class.getResource("/mapping.xml");
        mapping.loadMapping(url);
        // initialize and configure XMLContext
        XMLContext context = new XMLContext();
        OrderItem orderItem = createOrderItem();
        context.addMapping(mapping);
        testMarshalling(orderItem, context);
        testUnMarshalling(context);
    }

    private static OrderItem createOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setId("10");
        orderItem.setOrderQuantity(23);
        return orderItem;
    }

    private static void testUnMarshalling(XMLContext context) throws IOException, MappingException, MarshalException, ValidationException {

        // Create a Reader to the file to unmarshal from
        FileReader reader = new FileReader(outputXmlFileName);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        unmarshaller.setClass(OrderItem.class);
        OrderItem orderItem = (OrderItem) unmarshaller.unmarshal(reader);
        System.out.println(orderItem);
    }

    private static void testMarshalling(OrderItem orderItem, XMLContext context) throws IOException, MarshalException, ValidationException {
        // create a Writer to the file to marshal to
        Writer writer = new FileWriter(outputXmlFileName);
        //create a new Marshaller
        Marshaller marshaller = context.createMarshaller();
        marshaller.setWriter(writer);
        // marshal the person object
        marshaller.marshal(orderItem);
    }
}
