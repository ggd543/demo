package pd

/**
 * 
 * User: 刘永健
 * Date: 12-10-1
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */


//object Types{
//  abstract  class Type{
//    def sym : Symbols.Symbol
//  }
//}

trait Types{

  type S   // Symbol 仅仅是一个表示类型的符号

  abstract class Type {
    def sym: S
  }
}

