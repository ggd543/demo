package mybatis

import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.{ResultContext, ResultHandler, SqlSessionFactoryBuilder}
import reflect.{BeanProperty}
import org.apache.ibatis.annotations.Select
import scala.collection.JavaConversions._

/**
 *
 * User: 刘永健
 * Date: 12-2-18
 * Time: 上午7:57
 * To change this template use File | Settings | File Templates.
 */

class Account {
  @BeanProperty
  var username: String = _
  @BeanProperty
  var password: String = _

}

trait AccountMapper {
  @Select(Array("SELECT * from Account where password = #{password}"))
  def selectAccountByPassword(password: String): java.util.List[Account]
}

object Account {
  def main(args: Array[String]): Unit = {
    val reader = Resources.getResourceAsReader("sql-map-config.xml")
    val sqlMapper = new SqlSessionFactoryBuilder().build(reader)
    sqlMapper.getConfiguration.addMapper(classOf[AccountMapper])

    val session = sqlMapper.openSession()
    val account = session.selectOne("mybatis.Account.getAccountById", 1).asInstanceOf[Account]
    println("username: " + account.username + " password: " + account.password)

    val jack = session.select("mybatis.Account.getAccount", "Jack", new ResultHandler() {
      def handleResult(resContext: ResultContext) {
        val jack = resContext.getResultObject.asInstanceOf[Account]
        println("username: " + jack.username + " password: " + jack.password)
      }
    })

    println("-----------------------------")

    val accountMapper = session.getMapper(classOf[AccountMapper])
    val accountList = accountMapper.selectAccountByPassword("abc123")
    accountList.foreach {
      e =>
        println(e.username + " " + e.password)
    }
    session.close()
  }
}
