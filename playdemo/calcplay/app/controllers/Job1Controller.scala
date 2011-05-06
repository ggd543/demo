package controllers

import play.mvc.Controller
import util.Random

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
object Job1Controller extends Controller {
  def doJob() {
    val n = 30000    
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)        
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}

object Job2Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job3Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job4Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job5Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
  }
}


object Job6Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job7Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job8Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
  }
}


object Job9Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
    Json("ok")
  }
}


object Job10Controller extends Controller {
  def doJob() {
    val n = 30000
    for (i <- 0 until n) {
      if (i % 100 == 0) {
        play.info(request.controller + "  -  " + Thread.currentThread + " " + request.method + " " + request.actionMethod + " " + i)
        Thread.sleep(new Random().nextInt(10) * 100)
      }
    }
  }
}