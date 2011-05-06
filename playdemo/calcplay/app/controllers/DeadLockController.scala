package controllers

import play.mvc.Controller
import jobs.{DeadLockJob2, DeadLockJob1}

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
 *pla
 * $HeadURL$
 * @author      Archer
 * @version     $Revision$   $Date$
 * @see
 * @since
 ******************************************************************************/
object DeadLockController extends Controller{
  def lock() ={
    val i1 = new java.lang.Integer(1)
    val i2 = new java.lang.Integer(2)
    new DeadLockJob1(i1, i2).now()
    new DeadLockJob2(i1, i2).now()    
    Json("ok")
  }
}
