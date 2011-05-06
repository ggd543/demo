package poso


import reflect.BeanProperty

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-12-29
 * Time: 8:09:25
 * To change this template use File | Settings | File Templates.
 */

abstract class AbstractProduct {
  @BeanProperty
  var productId: java.lang.Long = _
  @BeanProperty
  var price: java.lang.Double = _
}