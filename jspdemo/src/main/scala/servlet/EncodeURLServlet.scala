package servlet

import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-8-27
 * Time: 下午3:30
 * To change this template use File | Settings | File Templates.
 */
class EncodeURLServlet extends HttpServlet{
  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {
    val session = req.getSession(true)
    val buf = new StringBuilder()
    buf ++= "http://"
    buf ++= req.getServerName
    buf ++= req.getRequestURI
    val newUrl = resp.encodeURL(buf.toString())
    println(newUrl)
    val pw = resp.getWriter
    pw.write(newUrl)
    pw.flush()
  }
}
