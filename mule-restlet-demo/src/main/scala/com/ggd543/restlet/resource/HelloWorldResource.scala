package com.ggd543.restlet.resource

/*
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-10-8
 * Time: 下午11:43
 */
import org.restlet.Context
import org.restlet.data.{MediaType, Request, Response}
import org.restlet.resource.{Representation, StringRepresentation, Variant, Resource}
;

class HelloWorldResource(context: Context, req: Request, res: Response) extends Resource(context, req, res) {
  getVariants().add(new Variant(MediaType.TEXT_PLAIN));
  getVariants().add(new Variant(MediaType.APPLICATION_XML));
  getVariants().add(new Variant(MediaType.APPLICATION_JSON));
 
  override def represent(variant: Variant): Representation = {
    new StringRepresentation("Hello World", MediaType.TEXT_PLAIN);
  }
}