package com.ggd543.dbutil

import com.jolbox.bonecp.{BoneCP, BoneCPConfig}
import java.util.concurrent.TimeUnit


/**
 *
 * User: 刘永健
 * Date: 12-3-26
 * Time: 上午10:31
 * To change this template use File | Settings | File Templates.
 */

object DB {
  private val bonecp = initBoneCP()

  private def initBoneCP() = {
    Class.forName("com.mysql.jdbc.Driver")
    val boneConf = new BoneCPConfig()
    boneConf.setJdbcUrl("jdbc:mysql://localhost:3306/test")
    boneConf.setUsername("root")
    boneConf.setPassword("1234")
    // 设置连接池在每个分区中的最大连接数
    boneConf.setMaxConnectionsPerPartition(2);
    // 设置连接池设在每个分区中的最小连接数
    boneConf.setMinConnectionsPerPartition(1);
    // 连接释放处理
    boneConf.setReleaseHelperThreads(3);
    // 当连接池中的连接耗尽的时候 BoneCP一次同时获取的连接数
    boneConf.setAcquireIncrement(5);
    // 设置分区(设置 3个分区)
    boneConf.setPartitionCount(1);
    // 当无法从连接池获取有效连接时，超过这个时间就抛出异常（0表示阻塞)
    boneConf.setConnectionTimeout(100, TimeUnit.MILLISECONDS)
    //    设置连接空闲时间(分钟)
    boneConf.setIdleMaxAge(30, TimeUnit.SECONDS);
    // 每120秒检查所有连接池中的空闲连接
    boneConf.setIdleConnectionTestPeriod(10, TimeUnit.SECONDS);
    // 获取连接失败后隔多少毫秒重试
    boneConf.setAcquireRetryDelayInMs(10)
    // 获取连接失败后，重试3次(默认是5次)
    boneConf.setAcquireRetryAttempts(3)
    new BoneCP(boneConf);
  }

  def getConn() = {
    bonecp.getConnection
  }

}

object DBTest extends App {
  val conn1 = DB.getConn()
  val conn2 = DB.getConn()
  println(conn1)
  println(conn2)
  try {
    DB.getConn()
  } catch {
    case ex => println(ex)
  }
  conn1.close()
//  conn2.close()
  val conn3 = DB.getConn
  conn3.close
  conn2.close
}
