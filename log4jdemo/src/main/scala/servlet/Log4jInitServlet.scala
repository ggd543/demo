package servlet


import javax.servlet.http.HttpServlet
import org.apache.log4j.PropertyConfigurator

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
class Log4jInitServlet extends HttpServlet {
  override def init = {
        println("init Log4jInitServlet")
    val context = getServletContext
    //    println(context.getRealPath("/"))
    val propFileName = context.getRealPath("/") + "WEB-INF/log4j.properties"
    //    println(propFileName)
     PropertyConfigurator.configure(propFileName)
  }
}