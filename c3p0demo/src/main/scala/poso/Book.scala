package poso


import reflect.BeanProperty

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 2009-12-29
 * Time: 8:10:07
 * To change this template use File | Settings | File Templates.
 */

class Book extends AbstractProduct {
  @BeanProperty
  var author: String = _
  @BeanProperty
  var description: String = _
}