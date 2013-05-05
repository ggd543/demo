/*
 * @(#) JExcelApiDemo.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-05-03
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.travelsky.jexcelapi;

import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * @author liuyongjian
 * @version 1.0
 */
public class JExcelApiDemo {
    public static void main(String[] args) throws IOException, BiffException {
//        InputStream is = JExcelApiDemo.class.getResourceAsStream("/wzllgjdb.xlsx");
        InputStream is = JExcelApiDemo.class.getResourceAsStream("/机场测试环境配置信息.xls");
        Workbook workbook = Workbook.getWorkbook(is);
        Sheet sheet = workbook.getSheet(0);

        Cell a1 = sheet.getCell(0,0);
        Cell b2 = sheet.getCell(1,1);
        Cell c2 = sheet.getCell(2,1);

        String stringa1 = a1.getContents();
        String stringb2 = b2.getContents();
        String stringc2 = c2.getContents();

        System.out.println("cell(0,0): "+stringa1);
        System.out.println("cell(1,1): "+stringb2);
        System.out.println("cell(2,1): "+stringc2);
    }
}
