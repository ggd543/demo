package models

import com.orientechnologies.orient.core.db.`object`.{ODatabaseObjectTx, ODatabaseObject}
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery
import scala.collection.JavaConverters._
import com.orientechnologies.orient.core.query.OQuery
import com.orientechnologies.orient.core.db.{ODatabaseComplex, ODatabasePojoAbstract}

class User extends Object {
  var name: String = _
  var email: String = _
}

object Run {
  def main(args: Array[String]) {
    val strUrl = ""
    val db = new ODatabaseObjectTx("""local:D:\orientdb-1.0rc2-SNAPSHOT\bin\orientdb-1.0rc2-SNAPSHOTdatabasesmydemo""")
    db.open("admin", "admin")

    val user = new User
    user.name = "AAA"
    user.email = "aaa@aaa.com"

    db.save(user)
    //
    val q = new OSQLSynchQuery[User]("select * from user")
    //		val users = db.asInstanceOf[ODatabaseComplex[_]].query(q.asInstanceOf[OQuery[User]]).asInstanceOf[List[User]]
    val users = db.asInstanceOf[ODatabaseComplex[_]].query(q).asInstanceOf[List[User]]
    for (user <- users) {
      println("User: " + user.name)
    }
    db.close()
  }

  //	private def toArr[T](params: T*): Array[T] = {
  //		params.map(_.asInstanceOf[T]).toArray
  //	}
}
