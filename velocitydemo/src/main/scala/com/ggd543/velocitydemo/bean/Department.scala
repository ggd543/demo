package com.ggd543.velocitydemo.bean

import reflect.BeanProperty

/**
 *
 * User: 刘永健
 * Date: 12-1-29
 * Time: 下午5:12
 * To change this template use File | Settings | File Templates.
 */

class Department(
                  @BeanProperty
                  val id: Int,
                  @BeanProperty
                  val deptname: String
                  ) {

}