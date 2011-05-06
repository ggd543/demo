package controllers

import play.mvc.Controller
import jobs.TestCacheJob
import play.cache.Cache
import models.Student

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
object TestController extends Controller {
  def testCache(n: Int) {
    val times = if (n == 0) 5 else n
    //    if (times < 1000) renderText("n should be more than or equal to 1000")
    new TestCacheJob(times).now
    renderText("Will try to create and cache %d Student objects".format(times))
  }

  def clearCache() {
    Cache.clear()
    renderText("The Play Cache has been clear up")
  }

  def loadAllStudents() {
    val tp1 = System.currentTimeMillis
    val stuList = Student.findAll
    val tp2 = System.currentTimeMillis
    val msg = "%d ms, total %d objects".format((tp2 - tp1), stuList.size)
    play.info(msg)
    renderText(msg)
  }

  def calcCorrelation(){
      
  }
}