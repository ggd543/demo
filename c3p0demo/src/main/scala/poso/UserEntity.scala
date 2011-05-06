package poso

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 2009-12-6
 * Time: 19:01:17
 * To change this template use File | Settings | File Templates.
 */


class UserEntity {
  var userId: Long = _
  var username: String = _
  var password: String = _
//  var name: String = _

  override def toString = "userId: " + userId + " username: " + username + " password: " + password

  override def hashCode = userId.toInt

  override def equals(obj: Any):Boolean = {
    obj match {
      case null => false
      case ex: UserEntity => if (userId == ex.userId) true else false
    }
  }  
}