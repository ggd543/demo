package controllers

import play.mvc.Controller
import java.net.URI
import play.Play
import play.mvc.results.RenderText
//import jobs.SuspendJob
import java.util.concurrent.Future


/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 2010-9-26
 * Time: 22:48:10
 * To change this template use File | Settings | File Templates.
 */

object Application extends Controller {
  def index() = Template()

  def json() = Json("Hello")
  
  def jar() ={
    val uri = new URI(classOf[Play].getResource("/play/version").toString)
    System.out.println(uri+"\nschema: "+uri.getScheme+ " schemaSpecificPart: "+uri.getSchemeSpecificPart)
    Text(uri.toString())
  }

  def file()={
    val uri = new URI(Play.classloader.getResource("messages").toString)
    System.out.println(uri+"\nschema: "+uri.getScheme+ " schemaSpecificPart: "+uri.getSchemeSpecificPart)
    Text(uri.toString())
  }

//  def suspend(seconds: Long) {
//    if (request.isNew) {
//      val future = new SuspendJob(seconds).now()
//      request.args.put("future", future)
//      WaitFor(future)
//    }
//    val future = request.args.get("future").asInstanceOf[Future[Double]]
//    val result = future.get()
//    Text(result)
//
//  }

  
  
}
