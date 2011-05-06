package utils;

import java.io.IOException;
import java.io.InputStream;

/**
 * ****************************************************************************
 * Copyright (c) 2010 Kalengo, LLC. All Rights Reserved.
 * <p/>
 * This software is the confidential and proprietary information of
 * Kalengo, LLC. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kalengo.
 * <p/>
 * KALENGO MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY
 * OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. KALENGO SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 * <p/>
 * CopyrightVersion 1.0
 * <p/>
 * <p/>
 * <p/>
 * $HeadURL$
 *
 * @author Archer
 * @version $Revision$   $Date$
 * @see
 * @since ****************************************************************************
 */

public class IO {

    /**
     * @See readString(InputStream)
     */
    public static byte[] readBytes(InputStream is) throws IOException {
        return readString(is).getBytes();
    }

    /**
     * After the invocation, the inputstream is closed.
     */
    public static String readString(InputStream is) throws IOException {
        byte[] buf = new byte[512];
        StringBuffer strBuf = new StringBuffer();
        int len = -1;
        while ((len = is.read(buf, 0, buf.length)) != -1) {
            strBuf.append(new String(buf, 0, len));
        }
        is.close();
        return strBuf.toString();
    }

    public static String XoR(String str) {
        //TODO
        return str;
    }

}

