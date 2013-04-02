/*
 * @(#) Employ.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-04-02
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package sample

import reflect.BeanProperty

class Employ {
  /**
   * 学历信息
   */
  @BeanProperty
  var eduInfo: String = _
  /**
   * 简历信息
   */
  @BeanProperty
  var resume: String = _
  /**
   * 考核信息
   */
  @BeanProperty
  var annualExam: String = _
  /**
   * 奖罚信息
   */
  @BeanProperty
  var awardPunish: String = _

  /**
   * 基本工资
   */
  @BeanProperty
  var basicSalary: Double = _
  /**
   * 职务工资
   */
  @BeanProperty
  var dutySalary: Double = _
  /**
   * 分红金额
   */
  @BeanProperty
  var bonus: Double = _

  @BeanProperty
  var percent: Double = _
  /**
   * 总和工资
   */
  @BeanProperty
  var totalSalary: Double = _

  override def toString() = {
     "[" + eduInfo + " " + resume + " " + annualExam + " " + awardPunish + " " + basicSalary + " " + dutySalary + " " + bonus + " " + totalSalary + "]";
  }
}
