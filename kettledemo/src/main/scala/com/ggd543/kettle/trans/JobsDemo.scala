package com.ggd543.kettle.trans

import org.pentaho.di.core.KettleEnvironment
import org.pentaho.di.core.util.EnvUtil
import org.pentaho.di.job.{Job, JobMeta}

/**
 *
 * User: 刘永健
 * Date: 12-3-8
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */

object JobsDemo extends App {
  execJobs(args(0))

  def execJobs(fileName: String) = {
    KettleEnvironment.init()
    EnvUtil.environmentInit()
    val jobMeta = new JobMeta()
    jobMeta.setFilename(fileName)
    val job = new Job(null ,jobMeta)
    job.execute(1, null)
    job.waitUntilFinished();
    if (job.getErrors > 0) {
      throw new RuntimeException("There were errors during job execution")
    }
  }
}
