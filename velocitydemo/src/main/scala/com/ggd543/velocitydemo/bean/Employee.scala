package com.ggd543.velocitydemo.bean

import reflect.BeanProperty

/**
 *
 * User: 刘永健
 * Date: 12-1-29
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */

class Employee(
                @BeanProperty
                val id: Int,
                @BeanProperty
                val ename: String,
                @BeanProperty
                val eaddress: String,
                @BeanProperty
                val age: Int,
                @BeanProperty
                val department: Department
                )