package jobs

import play.jobs.Job
import models.Student
import java.util.Date
import play.cache.Cache

/*******************************************************************************
 * Copyright (c) 2010 Kalengo, LLC. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Kalengo, LLC. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kalengo.
 *
 * KALENGO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. KALENGO SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 *
 * CopyrightVersion 1.0
 *
 *
 *
 * $HeadURL$
 * @author Archer
 * @version $Revision$ $Date$
 * @see
 * @since
 ******************************************************************************/
class TestCacheJob(val times: Int) extends Job {
  //  require(times >= 1000, "the variable times must be more than or equal to 1000")
  private val USER_NAME_PREFIX = "user_"
  private val N = 500

  override def doJob() {
    val tp1 = System.currentTimeMillis
    for (i <- 0 until times) {
      val username = USER_NAME_PREFIX + i
      val stu = new Student(i, username, new Date())
      Cache.set(username, stu, "120s")
      //      Cache.set(username, username, "5s")
            if (i % N == 0)
      play.debug("Have cache %d Student objects, free memory: %f MB", i, Runtime.getRuntime.freeMemory / 1024.0 / 1024.0)
    }
    val tp2 = System.currentTimeMillis
    play.info("%f seconds, Done!", (tp2 - tp1) / 1000.0)
  }

}