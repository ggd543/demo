package servlet


import javax.servlet.http.{HttpServletResponse, HttpServletRequest, HttpServlet}
import org.apache.log4j.Logger
import utils.LogUtils


/*******************************************************************************
 * Copyright (c) 2009 Kalengo, LLC. All Rights Reserved.
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
 * @author $Author $
 * @version $Revision $   $Date $
 * @see
 * @since
 ******************************************************************************/
class Log4jServlet extends HttpServlet {
  val logger = LogUtils.LOG4J_LOGGER

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) = {
    val msg = "doGet in Log4jServlet"
    logger.error(msg)
    val pw = resp.getWriter
    pw.println(msg)
    pw.flush
    val myLogger=Logger.getLogger("LOG4JDEMO")
    myLogger.error(msg+"  Hello world")
  }

}