package controllers

import play.mvc.{Before, Controller}

/**
 * Created by IntelliJ IDEA.
 * User: computer
 * Date: Jun 18, 2010
 * Time: 11:50:12 AM
 * To change this template use File | Settings | File Templates.
 */
//trait AuthorizationHandler extends Controller with ExceptionHandler {
trait AuthorizationHandler{
  self: Controller with ExceptionHandler =>  

  @Before(priority = 5)
  def checkPermission() {
     play.info("checkPermission ..");    
  }
}