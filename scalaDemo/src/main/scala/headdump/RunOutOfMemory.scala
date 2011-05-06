package headdump

import collection.mutable.HashSet

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-1-27
 * Time: 下午11:39
 * To change this template use File | Settings | File Templates.
 */


class User(val id: Int, val name: String)

object RunOutOfMemory {
  def main(args: Array[String]): Unit = {
    val set = new HashSet[User]

    while(true){
      set += new User(1, "Jack")
    }
    
  }
}
