package jobs

import play.jobs.Job

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
 * @author      Archer
 * @version     $Revision$   $Date$
 * @see
 * @since
 ******************************************************************************/
class DeadLockJob2(private var i1: java.lang.Integer, private var i2: java.lang.Integer) extends Job {
  override def doJob() {
    i2.synchronized {
      play.info("synchronized(i2) ")
      Thread.sleep(5000L)
      i1.synchronized {
        play.info("synchronized(i1) ")
        Thread.sleep(5000L)
      }
    }
    play.info("DeadLockJob1 finish");
  }
}