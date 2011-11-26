package com.ggd543.mulerestletdemo

import org.restlet.data.{MediaType, Response, Request}
import org.restlet.resource.{StringRepresentation, Variant, Resource}
import org.restlet.{Router, Context}

/**
 * Created by IntelliJ IDEA.
 * User: ggd543
 * Date: 11-11-24
 * Time: 上午11:40
 * To change this template use File | Settings | File Templates.
 */

class HelloWorldApplication extends org.restlet.Application {

  override def createRoot() = {
     // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
      val router = new Router(getContext())
      router.attachDefault(classOf[HelloWorldResource])
     router
  }
}

class HelloWorldResource(context: Context, request: Request, response: Response)
  extends Resource(context, request, response) {
  getVariants.add(new Variant(MediaType.TEXT_PLAIN))


  override def getRepresentation(variant: Variant) = new StringRepresentation("Hello world")
}