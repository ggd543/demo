package pd

/**
*
* User: 刘永健
* Date: 12-10-1
* Time: 上午10:03
* To change this template use File | Settings | File Templates.
*/
class SymbolTable extends  AnyRef with Types with Symbols{
  override type S = Symbol
  override type T = Type
//   override  type S = String
//
  class SubType extends Type{
    def sym = new SubSymbol()
  }
//
  class SubSymbol extends Symbol{
    def tpe = new SubType()
  }
//
  def demo(){
    println(new SubType().sym)
    println(new SubSymbol().tpe)
  }
}

object SymbolTable extends App{
  val obj = new SymbolTable()
    obj.demo()
}