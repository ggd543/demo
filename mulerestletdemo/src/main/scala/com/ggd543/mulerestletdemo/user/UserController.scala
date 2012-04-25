package com.ggd543.mulerestletdemo.user

import org.mule.api.lifecycle.Callable
import org.mule.api.MuleEventContext

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 11-12-8
 * Time: 上午11:44
 * To change this template use File | Settings | File Templates.
 */
//
//class UserController( context: Context,request:  Request ,  response: Response) extends Resource(context, request, response) {
//    override  def getRepresentation(variant :   Variant) :  Representation = {
//
//    }
//}

class UserController extends Callable {

  def onCall(eventContext: MuleEventContext) = {
    val uri_endpoint = eventContext.getEndpointURI();
    println("address: " + uri_endpoint.getAddress)
    println("path: " + uri_endpoint.getPath);
    println("authority: " + uri_endpoint.getAuthority);
    println("uri: " + uri_endpoint.getUri)
    println("scheme: " + uri_endpoint.getScheme)
    "ok"
  }
}