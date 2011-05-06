package app


import com.mchange.v2.c3p0.{DataSources, ComboPooledDataSource}

/*******************************************************************************
 * Copyright (c) 2009 Kalengo, LLC. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Kalengo, LLC. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kalengo.
 *
 * KALENGO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. KALENGO SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * CopyrightVersion 1.0
 *
 *
 *
 * $HeadURL$
 * @author $Author $
 * @version $Revision $   $Date $
 * @see
 * @since
 ******************************************************************************/
object C3P0App1 {
  def main(args: Array[String]): Unit = {
    val cpds = new ComboPooledDataSource();
    cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
    cpds.setJdbcUrl("jdbc:mysql://localhost/dbunit");
    cpds.setUser("root");
    cpds.setPassword("1234");

    cpds.setMinPoolSize(1);
    cpds.setAcquireIncrement(1);
    cpds.setMaxPoolSize(5);
    cpds.setMaxIdleTime(3);
    
    val conn1 = cpds.getConnection;
    println(conn1)
    conn1.close
    val conn2 = cpds.getConnection;
    println(conn2)
    conn2.close
    val conn3 = cpds.getConnection;
    println(conn3)
    conn3.close
    val conn4 = cpds.getConnection;
    println(conn4)
    conn4.close
    val conn5 = cpds.getConnection;
    println(conn5)
    conn5.close();
    val conn6 = cpds.getConnection;
    println(conn6)
    conn6.close
    
    println("--------- Sleep 10 seconds ------")
    Thread.sleep(10000L);
    //    DataSources.destroy(cpds);
    println(cpds.getConnection.getTransactionIsolation)    
  }
}