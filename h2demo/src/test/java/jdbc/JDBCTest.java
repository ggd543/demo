package jdbc;

import java.sql.*;
import org.junit.Assert.*;
import org.junit.*;
import org.apache.log4j.*;
import org.h2.tools.*;

public class JDBCTest{
	private Logger logger = Logger.getLogger(JDBCTest.class);
	
	private Server h2Server ;
	
	private final int port = 3106;
	
	private final String[] tcpArgs = new String[]{"-tcpPort", ""+port};
	
	@Before
	public void setUp(){
		try{
		logger.info("Load H2 JDBC Driver");
		Class.forName("org.h2.Driver");
		logger.info("start the TCP Server");
		h2Server = Server.createTcpServer(tcpArgs).start();
		}catch(Exception e){
			System.exit(1);
		}		
	}
	
	@After
	public void tearDown(){
		logger.info("stop the TCP Server");
		h2Server.stop();
	}
	
    @Test
	public void testConnWithEmbedded(){
		try{
        Connection conn = DriverManager.
            getConnection("jdbc:h2:db/test", "root", "1234");
        logger.info(" -- conn: "+conn+" --- " );
        conn.close();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}		
    }
	
	@Test
	public void testConnWithTcp(){		
		try{        
        Connection conn2 = DriverManager.
            getConnection("jdbc:h2:tcp://localhost:"+port+"/db/demo", "root", "1234");
        logger.info(" -- conn2: "+conn2+" --- " );
		
        conn2.close();
		}catch(Exception e){
			e.printStackTrace();
			Assert.fail();
		}		
    }
	
	@Test
	public void testConnWithMem(){
		try{
			Connection conn3 = DriverManager.getConnection("jdbc:h2:mem:");						
			Statement sm = conn3.createStatement();			
			sm.executeUpdate("drop table t_person if exists");
			Assert.assertEquals(0, sm.executeUpdate("create table t_person(id int primary key, name varchar(45))"));
			Assert.assertEquals(1, sm.executeUpdate("insert into t_person values(1,'archer')"));
			conn3.commit();
			ResultSet rs = sm.executeQuery("Select * from t_person");
			Assert.assertTrue(rs.next());
			logger.info("The number of records for table tperson: "+rs.getFetchSize());
			
			Connection conn4 = DriverManager.getConnection("jdbc:h2:mem:","","");
			Statement sm4 = conn4.createStatement();					
			try{
				ResultSet rs4 = sm4.executeQuery("Select * from t_person");
				Assert.fail();
			}catch(Exception e){
				Assert.assertTrue(true);
			}			
			conn3.close();
			conn4.close();
		}catch(Exception e){
			e.printStackTrace();
		   Assert.fail();
		}
	}
	
	
	
	
	
	
	
}