def sum(a: Int)(b: Int)(c: Int) = a +b +c // (a: Int)(b: Int)(c: Int)Int
val sum3 = sum _   // (Int) => (Int) => (Int) => Int = <function1>
sum3.isInstanceOf[Function1[Int,Function1[Int, Function1[Int, Int]] ]]   // true
sum3.isInstanceOf[Function3[Int, Int, Int, Int]]   // false
sum3.isInstanceOf[PartialFunction[_,_]]   //false
val sum1 = sum(2)(3) _  //(Int) => Int = <function1>
sum1.isInstanceOf[PartialFunction[Int, Int]]   //false

val defaultValue: Option[Int] => Int = {
case Some(x) => x
case None => 0
}
// (Option[Int]) => Int = <function1>

def check: PartialFunction[Int,String] = {case n if n > 0 =>  "P"; case 0 => "0"}  //PartialFunction[Int,String]



