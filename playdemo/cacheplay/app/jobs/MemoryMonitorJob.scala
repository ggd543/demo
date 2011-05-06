package jobs

import play.jobs.{Every, OnApplicationStart, Job}

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

@OnApplicationStart
@Every("60s")
class MemoryMonitorJob extends Job {
  override def doJob() {
    val runtime = Runtime.getRuntime
    play.info("Max Memory: %f MB, Total Memory: %f MB, Free Memory: %f MB",
      runtime.maxMemory / 1024.0 / 1024.0, runtime.totalMemory / 1024.0 / 1024.0, runtime.freeMemory / 1024.0 / 1024.0)
  }
}