package oata;

import org.junit.Assert.*;
import junit.framework.*;

public class AntHelloWorldTest extends TestCase{

	private AntHelloWorld instance;
		
	public void setUp(){
		instance = new AntHelloWorld();
	}
	
	
	public void testAdd(){
		System.out.println("testAdd()");
		Assert.assertEquals(3, instance.add(1,1));
	}	
	
	public void testAdd2(){
		System.out.println("testAdd2()");
		Assert.assertTrue(true);
	}
	
}
