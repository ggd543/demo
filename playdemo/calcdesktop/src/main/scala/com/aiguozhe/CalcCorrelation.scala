package com.aiguozhe

import com.jamonapi.MonitorFactory
import org.apache.commons.math.stat.correlation.PearsonsCorrelation

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-9-26
 * Time: 23:33:40
 * To change this template use File | Settings | File Templates.
 */

object CalcCorrelation {
  def main(args: Array[String]) {
    val x = Array.fill(100)(Math.random)
    val y = Array.fill(100)(Math.random)
//    val times = if (args.length > 0) args(0).toInt else 1000
    val times = 1000
    val corr = new PearsonsCorrelation()
    val monitor = MonitorFactory.start("Correlation")
    monitor.start()
    for (i <- 0 until times) {
      corr.correlation(x, y)
    }
    monitor.stop()
    println(monitor.toString())
  }
}
