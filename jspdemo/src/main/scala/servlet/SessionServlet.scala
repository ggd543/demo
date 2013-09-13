package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-6
 * Time: 下午1:43
 * To change this template use File | Settings | File Templates.
 */
class SessionServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val session = req.getSession(true);
    val sessionId = session.getId();
    val sid = req.getParameter("jsessionid");
    val msg = new StringBuilder;
    msg ++= "sessionId: " + sessionId + " sid: " + sid + " \n";
    msg ++= "cookies: \n"
    if (req.getCookies != null) {
      for (cookie <- req.getCookies()) {
        msg ++= cookie.getName + " " + cookie.getValue + " \n"
      }
    }
    println(msg)
    val pw = resp.getWriter;
    pw.append(msg)
    pw.flush();
  }
}
