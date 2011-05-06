package poso


import reflect.BeanProperty

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-12-15
 * Time: 22:34:41
 * To change this template use File | Settings | File Templates.
 */

class DateEntity{
  @BeanProperty            
  var id: java.lang.Long = _
  @BeanProperty 
  var date: java.util.Date = _
}