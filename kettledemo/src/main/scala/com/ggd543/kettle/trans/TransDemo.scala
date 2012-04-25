package com.ggd543.kettle.trans

import org.pentaho.di.core.util.EnvUtil
import org.pentaho.di.core.KettleEnvironment
import org.pentaho.di.trans.{Trans, TransMeta}

/**
 *
 * User: 刘永健
 * Date: 12-3-8
 * Time: 下午12:14
 * To change this template use File | Settings | File Templates.
 */

object TransDemo extends App {

  execTrans(args(0))  // ktr文件的全路径

  def execTrans(fileName: String) {
    KettleEnvironment.init()
    EnvUtil.environmentInit();
    val transMeta = new TransMeta(fileName)
    val trans = new Trans(transMeta)
    trans.execute(null) // you can pass arguments instead of null
    trans.waitUntilFinished();
    if (trans.getErrors > 0) {
      throw new RuntimeException("There were errors during transformation execution")
    }

  }
}
