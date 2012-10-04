package pd

/**
 * 
 * User: 刘永健
 * Date: 12-10-1
 * Time: 上午9:58
 * To change this template use File | Settings | File Templates.
 */


//object Symbols{
//  abstract class Symbol{
//    def tpe: Types.Type
//  }
//}

trait Symbols{

  type T

  abstract  class Symbol{
    def tpe : T
  }
}
