package demo

/**
 *
 * User: 刘永健
 * Date: 12-3-19
 * Time: 下午5:08
 * To change this template use File | Settings | File Templates.
 */

object EmptyListDemo {
 def main(args: Array[String]) = {
   List.empty[String].forall( _ == "a")
   }
}
