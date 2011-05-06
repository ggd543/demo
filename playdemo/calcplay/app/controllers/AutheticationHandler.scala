package controllers

import util.Random
import play.mvc.{Util, Before, Controller}

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
trait AutheticationHandler {
  self: Controller with ExceptionHandler =>

  @Before(priority = 2)
  def autheticate() {
    try {
      val n = new Random().nextInt(2)
      if (n == 1) {
        play.info("autheticate ...")
        this.f()
      }
    } catch {
      case e => handle(e)
    }
  } //autheticate

  @Util
  private def f() {
    throw new RuntimeException("Just for test")
  }
}