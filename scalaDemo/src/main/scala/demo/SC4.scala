/**
 * Created by 刘永健
 * User: 刘永健
 * Date: 11-11-25
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
package demo {
package util {

import java.util.Date
import java.text.SimpleDateFormat

object DateUtil {
  class DateWrapper(date: Date) {
    def format(str: String) = new SimpleDateFormat(str).format(date)
  }
  implicit def toDateWrapper(date: Date) = new DateWrapper(date)
}
}

package service {
import java.text.SimpleDateFormat
import java.util.Date
//   这个伴随对象 必须放在Rest类之前，否则Rest.getDate的实现 会报错
   object Rest{
    class RichDate(str: String){
      def toDate(): Date = new SimpleDateFormat("yyyy-MM-dd").parse(str)
    }
    implicit def str2Date(str: String) = new RichDate(str)
  }
class Rest {
  import util.DateUtil._
  import Rest._
  // 必须把demo.util包下的伴随对象DateWrapper中的所有成员引进来
  def today = new Date().format("yyyy-MM-dd");
  // 伴随对象 Rest中定义了一个隐式转换函数
  def getDate(str: String): Date = str.toDate();
}

}

object SC4 {
  import demo.service.Rest
   def main(args: Array[String]) ={
     println (new Rest().today)
     println(new Rest().getDate("2011-01-09"))
   }
}
}
