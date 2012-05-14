package servlet

import java.util.concurrent.{Executors, Executor}
import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}

/**
 *
 * User: 刘永健
 * Date: 12-3-19
 * Time: 下午9:30
 * To change this template use File | Settings | File Templates.
 */

class MyServlet extends HttpServlet {
  private val pool = Executors.newFixedThreadPool(1) // create a thread pool

  override def doGet(req: HttpServletRequest, res: HttpServletResponse) = {
//    val writer = res.getWriter
//    writer.println("hello")
//    writer.flush()

    req.startAsync //tell the container that the response will be generated later
    pool.execute(new Runnable() {
      // add the runnable to the queue
      def run {
        // when a thread in pool picks up the runntable...
        res.getWriter.append("hello world!") // write the response
        println("I want to sleep 3s...")
        Thread.sleep(3000L)
        req.getAsyncContext.complete // tell the container that the response is done
      }
    })
    // return without a response yet
  }
}
