package com.ggd543.velocitydemo

//package com.ggd543.velocitydemo

import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.VelocityContext
import java.io.StringWriter
import reflect.BeanProperty
import collection.JavaConversions.JListWrapper
import scala.collection.JavaConversions._
import java.util.{Properties, HashMap}

/**
 * @author ${user.name}
 */
object Helloworld {

  val prop = {
    val p = new Properties
    p.setProperty("directive.foreach.counter.name", "velocityCount") // Default name of loop counter
    p.setProperty("directive.foreach.counter.initial.value", "0")
    p.setProperty("output.encoding", "UTF-8")
    p
  }

  def main(args: Array[String]) {

    //First , get and initialize an engine
    val ve = new VelocityEngine();
    ve.init(prop);

    //Second, get the template
    //    val t = ve.getTemplate("helloworld.vm");
    val t = ve.getTemplate("helloworld.vm");
    //Third, create a context and add data
    val context = new VelocityContext();
    context.put("name", "Archer")
    context.put("site", "http://www.baidu.com")

    val user = new User("Jack")
    user.age = 23;
    user.password = "1234"

    context.internalPut("user", user)

    context.internalPut("table", mapAsJavaMap(Map("name" -> "Fuxk")))
    //    context.internalPut("table", Map("name" -> "Fuxk"))

    //    Finally , render the template into a StringWriter
    val sw = new StringWriter
    t.merge(context, sw)
    println(sw.toString);
  }

}

class User(val name: String) {


  @BeanProperty
  var password: String = _
  @BeanProperty
  var age: Int = _
  @BeanProperty
  var friends: java.util.List[User] = _

  def talk(msg: String) = "Hello, " + msg

  def produceFriends(): java.util.List[User] = List(new User("Cherry"), new User("Ray"))

  def greeting = {
    println("heihei ~~ ")
    "welcome ... "
  }


}