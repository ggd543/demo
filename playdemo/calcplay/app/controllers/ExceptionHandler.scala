package controllers

import play.exceptions.PlayException
import play.mvc.{Util, Controller, Catch}
import play.mvc.results.{Result, RenderJson}

/**
 * Created by IntelliJ IDEA.
 * User: computer
 * Date: Jun 18, 2010
 * Time: 3:09:44 PM
 * To change this template use File | Settings | File Templates.
 */

trait ExceptionHandler {
  self: Controller =>

  @Catch(Array(classOf[Exception]))
  def handle(e: Throwable) : Result = {
    return new RenderJson("Why")
    
    e match {
      case ex: PlayException => throw ex
      case ex => renderException(ex)
    }
  }

  @Util
  private def renderException(ex: Throwable) = {
    play.info("ExceptionHandler.handle(%s)", ex.getMessage)
    Json(ex.getStackTraceString)
  }
}