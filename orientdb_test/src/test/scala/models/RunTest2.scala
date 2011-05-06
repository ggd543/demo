/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-5-6
 * Time: 上午12:25
 */
package models

import com.orientechnologies.orient.core.db.`object`.{ODatabaseObjectTx, ODatabaseObjectPool}
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery

import java.lang.{Long => JLong}
import java.util.{List => JList}
import com.orientechnologies.orient.core.db.ODatabaseComplex

object RunTest2 {
  def main(args: Array[String]): Unit = {
    val strUrl = """local:D:\orientdb-1.0rc2-SNAPSHOT\bin\orientdb-1.0rc2-SNAPSHOTdatabasesmydemo"""
    val db = ODatabaseObjectPool.global().acquire(strUrl, "admin", "admin").asInstanceOf[ODatabaseObjectTx];
    
    db.getEntityManager().registerEntityClass(classOf[User]);
    db.open("admin", "admin");
    val user = new User();
    user.name = "aaa";
    user.email = "ggd543@gmail.com"
    db.save(user);
//    db.commit();
    val list = db.asInstanceOf[ODatabaseComplex[_]].query(new OSQLSynchQuery[JLong]("select count(*) from User")).asInstanceOf[JList[JLong]];
    System.out.println(list);
//    db.commit();
//db.rollback
    ODatabaseObjectPool.global().release(db)
    //db.close();

  }

}