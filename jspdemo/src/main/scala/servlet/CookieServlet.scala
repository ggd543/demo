package servlet

import javax.servlet.http.{Cookie, HttpServletResponse, HttpServletRequest, HttpServlet}


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-27
 * Time: 上午11:23
 * To change this template use File | Settings | File Templates.
 */
class CookieServlet extends HttpServlet {

  override def init() {
  }

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val c1 = new Cookie("c1", "v1")
    val c2 = new Cookie("c2", "v2")
    resp.addCookie(c1)
    resp.addCookie(c2)

  }
}
