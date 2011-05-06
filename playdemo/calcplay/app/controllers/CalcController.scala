package controllers

import play.mvc.Controller
import com.jamonapi.MonitorFactory
import org.apache.commons.math.stat.correlation.PearsonsCorrelation
import java.util.Random
//import jobs.LongJob
import java.util.concurrent.Future
import play.mvc.results.RenderText

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-9-26
 * Time: 22:50:12
 * To change this template use File | Settings | File Templates.
 */

object CalcController extends Controller {
  def calcCorrelation(n: Int) = {
    //    val times = if (n == 0) 1000 else n
    val times = 100000
    val x = Array.fill(100)(Math.random)
    val y = Array.fill(100)(Math.random)
    val corr = new PearsonsCorrelation()
    val monitor = MonitorFactory.start("Correlation")
    monitor.start()
    for (i <- 0 until times) {
      corr.correlation(x, y)
    }
    monitor.stop()
    Text(monitor.toString())
  }

  def longCalc1() = {
//    val n = java.lang.Integer.MAX_VALUE;
    val n = 100000;
    var sum = 0
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        sum *= i
        play.info(request.controller + "   " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        //        Thread.sleep(new Random().nextInt(10)* 100)
      }
    }
    Json(sum)
  }


  def longCalc2() = {
//    val n = java.lang.Integer.MAX_VALUE;
    val n = 100000;
    var sum = java.lang.Double.MAX_VALUE
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        sum /= (i + 1)
        play.info(request.controller + "   " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        //        Thread.sleep(new Random().nextInt(10)* 100)
      }
    }
    Json(sum)
  }
//
//  def longCalcJob() = {
//    if (request.isNew) {
//      val future = new LongJob().now()
//      request.args.put("future", future)
//      WaitFor(future)
//    }
//    val future = request.args.get("future").asInstanceOf[Future[Long]]
//    val sum = future.get().asInstanceOf[Long]
//    Text(sum)
//  }


}
