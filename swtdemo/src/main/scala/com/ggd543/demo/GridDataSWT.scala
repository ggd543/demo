/*
 * @(#) GridDataSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Text, Button, Shell, Display}
import org.eclipse.swt.layout.{GridData, GridLayout}
import org.eclipse.swt.SWT

object GridDataSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    shell.setText("GridData示例");
    val gridLayout = new GridLayout(); //创建网格布局对象
    gridLayout.numColumns = 3; //设置网格布局列数为3
    gridLayout.makeColumnsEqualWidth = true; //强制列宽相等
    shell.setLayout(gridLayout); //将shell设置为指定的网格布局式样

    val gridData = new GridData(); //创建网格布局数据对象
    gridData.horizontalSpan = 2; //水平方向跨2列
    gridData.verticalSpan = 2; //垂直方向跨2行
    gridData.horizontalAlignment = GridData.CENTER; //水平方向居中
    gridData.verticalAlignment = GridData.FILL; //垂直方向充满

    val b1 = new Button(shell, SWT.PUSH); //创建按钮对象b1
    b1.setText("B1");
    b1.setLayoutData(gridData); //将设定的网格布局数据用于按钮对象b1

    new Button(shell, SWT.PUSH).setText("超宽按钮 2");
    new Button(shell, SWT.PUSH).setText("按钮 3");

    val b4 = new Button(shell, SWT.PUSH);
    b4.setText("B4");
    //用带参数的构造方法创建gridData对象
    val gridData2 = new GridData(GridData.FILL_HORIZONTAL);
    b4.setLayoutData(gridData2); //将gridData用于b4，水平方向充满
    val  b5 = new Button(shell, SWT.PUSH);
    b5.setText("按钮 5");
    val gridData3= new GridData();
    gridData3.horizontalAlignment = GridData.FILL; //设置b5为水平方向充满
    b5.setLayoutData(gridData3);

    new Button(shell, SWT.PUSH).setText("按钮 6");
    val t1 = new Text(shell, SWT.BORDER);
    t1.setText("文本框 1");
    val gridData4 = new GridData();
    gridData4.verticalSpan = 2; //跨两行
    gridData4.horizontalSpan = 2; //跨两列
    gridData4.verticalAlignment = GridData.FILL; //垂直方向充满
    gridData4.horizontalAlignment = GridData.FILL; //水平方向充满
    gridData4.grabExcessVerticalSpace = true; //抢占垂直方向额外空间
    gridData4.grabExcessHorizontalSpace = true; //抢占水平方向额外空间
    t1.setLayoutData(gridData4); //gridData用于文本框t1

    new Button(shell, SWT.PUSH).setText("按钮 7");
    new Button(shell, SWT.PUSH).setText("按钮 8");
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
}
