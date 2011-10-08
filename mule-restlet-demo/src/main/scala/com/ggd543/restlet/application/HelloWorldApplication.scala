/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-10-9
 * Time: 上午12:08
 */
package com.ggd543.restlet.application

import org.restlet.{Router, Restlet}
import com.ggd543.restlet.resource.HelloWorldResource

;

class HelloWorldApplication extends org.restlet.Application {
  override def createRoot(): Restlet = {
     val router = new Router(getContext());
    //     router.attachDefault(classOf[HelloWorldResource]);
    router.attach("/helloworld", classOf[HelloWorldResource])
    return router;
  }
}