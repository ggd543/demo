/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-10-9
 * Time: 上午12:32
 */
package com.ggd543.restlet.client

//import org.restlet.util.Engine

import org.mule.transport.restlet.client.MuleClientHelper
import com.noelios.restlet.Engine
import org.restlet.data.Protocol
import org.restlet.Client
import org.restlet.resource.StringRepresentation
;

object HelloWorldResourceClient {
  def main(args: Array[String]): Unit = {
//    val engine = new Engine(false);
//    engine.getRegisteredClients().add(new MuleClientHelper());
//    Engine.setInstance(engine);
    val client = new Client(Protocol.HTTP);
    // GET a resource
    val response = client.get("http://localhost:9002/helloworld");
    val text = response.getEntity.asInstanceOf[StringRepresentation].getText;
    println(text)
    // POST to a resource
    //    response = client.post("http://localhost:63080/echo", new StringRepresentation("hello"));
  }
}