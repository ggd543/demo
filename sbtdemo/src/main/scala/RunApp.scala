package demo

import org.codehaus.jettison.json._

object RunApp{
	def main(args: Array[String]):Unit={
		println(new JSONObject().put("JSON", "Hello, World!").toString());
	}
	
}
