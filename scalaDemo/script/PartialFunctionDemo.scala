
object PartialFunctionDemo{
val defaultValue: Option[Int] => Int = {
case  Some(x) => x
case None => 0
}
def check: PartialFunction[Int,String] = {case n if n > 0 =>  "P"; case 0 => "0"}  //PartialFunction[Int,String]
}
