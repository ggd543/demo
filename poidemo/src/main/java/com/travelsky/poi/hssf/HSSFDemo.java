/*
 * @(#) HSSFDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-03
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.poi.hssf;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class HSSFDemo {
    public static void main(String[] args) {
        InputStream is = HSSFDemo.class.getResourceAsStream("/wzllgjdb.xlsx");
        try {
            POIFSFileSystem poifs = new POIFSFileSystem(is);
            HSSFWorkbook workbook = new HSSFWorkbook(poifs);

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
