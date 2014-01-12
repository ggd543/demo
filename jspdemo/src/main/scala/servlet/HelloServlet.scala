package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.slf4j.LoggerFactory

import scala.collection.JavaConversions._

class HelloServlet extends HttpServlet {
  //  private val logger = LoggerFactory.getLogger(classOf[HelloServlet])

  override def init() {

  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    println("request's classloader: "+req.getClass.getClassLoader);
    println("HelloServlet's classloader: "+this.getClass.getClassLoader+" , hashCode: "+this.getClass.getClassLoader.hashCode())
    println("request_session_id: " + req.getRequestedSessionId
      + " requestSessionIdFromCookie: " + req.isRequestedSessionIdFromCookie
      + "  requestSessionIdFromURL: " + req.isRequestedSessionIdFromURL
      + " isRequestSessionIdValid: " + req.isRequestedSessionIdValid)

    val session = req.getSession(false);
    if (session != null) {
      println("sessionId: " + session.getId)
      println(" ---- session attributes ----")
      for (name <- session.getAttributeNames) {
        println(name)
      }
      println("------------")
    } else {
      println("no session associated")
    }
    val pw = resp.getWriter;
    pw.println("Hello world")
    pw.flush();
    println("cache.jsp : "+req.getRealPath("/cache.jsp"))
    println("css : "+req.getRealPath("/css/"))
    println(getClass.getResource("cache.jsp"))
    println(super.getServletContext.getResourceAsStream("/cache.jsp"));
  }
}
