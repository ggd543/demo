package listener

import javax.servlet.http.{HttpSessionEvent, HttpSessionListener}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-9-11
 * Time: 下午5:40
 * To change this template use File | Settings | File Templates.
 */
class MySessionListener extends HttpSessionListener{

  def sessionDestroyed(se: HttpSessionEvent) {
    val session = se.getSession;
    println("========================================= ")
    println("session destroy : "+session+" (sessionId: "+session.getId+") ")
    println("========================================= ")
  }

  def sessionCreated(se: HttpSessionEvent) {
    val session = se.getSession;
    println("========================================= ")
    println("session created : "+session+" (sessionId: "+session.getId+") isNew: "+session.isNew)
    println("========================================= ")
  }
}
