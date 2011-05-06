package oata;

import org.apache.log4j.*;
import java.net.*;

public class AntHelloWorld{
	private static Logger logger = Logger.getLogger(AntHelloWorld.class);
	
	public static void  main(String []args){
		URL log4jUrl = ClassLoader.getSystemResource("log4j.properties");
        PropertyConfigurator.configure(log4jUrl);
		logger.info("Hello ant!");       
		logger.info(System.getProperty("java.class.path"));
//		System.out.println("Hello ant!");
	}
	
	public int add(int a, int b){
		return a+b;
	}	
}
