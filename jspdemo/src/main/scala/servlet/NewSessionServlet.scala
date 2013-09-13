package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-27
 * Time: 下午2:19
 * To change this template use File | Settings | File Templates.
 */
class NewSessionServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val session = req.getSession(true)
    val msg = "session: "+session+" isNew: "+session.isNew+" sessionId: "+session.getId;
    println(msg)
    val pw = resp.getWriter
    pw.append(msg)
    pw.flush()
  }
}
