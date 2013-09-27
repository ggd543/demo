package com.ggd543.demo;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-27
 * Time: 下午6:34
 * To change this template use File | Settings | File Templates.
 */
public class InspectionPerson {
    public static void main(String[] args) throws IOException, ParseException {
        testMarshall();
        testUnmarshall();
    }

    private static void testMarshall() throws IOException, ParseException {
        // Create a new Person
        Person person = new Person("Ryan 'Mad Dog' Madden");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        person.setDateOfBirth(df.parse("1985-07-19"));

        // Create a File to marshal to
        FileWriter writer = new FileWriter("test.xml");

        // Marshal the person object
        try {
            Marshaller.marshal(person, writer);
        } catch (MarshalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ValidationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private static void testUnmarshall() throws FileNotFoundException {
        // Create a Reader to the file to unmarshal from
        FileReader reader = new FileReader("test.xml");

        // Marshal the person object
        try {
            Person person = (Person) Unmarshaller.unmarshal(Person.class, reader);
            System.out.println(person);
        } catch (MarshalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ValidationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
