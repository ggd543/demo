import sbt._

class DemoProject(info: Project) extends DefaultProject(info){
	override def dependencyPath = crossPath("D:") / "lib" 
}
