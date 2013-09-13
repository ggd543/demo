package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-27
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
class InvalidateSessionServlet extends HttpServlet {
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val session = req.getSession(false)
    if (session != null) {
      session.invalidate();
    }
    val pw= resp.getWriter
    pw.append("session "+session+"  invalid: ")

  }
}
