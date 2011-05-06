package controllers

import play.mvc._

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
trait RestTracker{
  self: Controller with ExceptionHandler =>

  private val START = "START"

  @Before(priority = 0)
  def before() {
    play.info("$RestTracker, %s, %s".format(request.method + "", request.url))
    flash.put(START, System.currentTimeMillis)
  }

  @Finally(priority = 0)
  def after() {
    val method = request.method
    val url = request.url
    val time = System.currentTimeMillis - flash.get(START).toLong
    play.info("$RestTracker, %s, %s, %d milliseconds", method, url, time)
  }
}