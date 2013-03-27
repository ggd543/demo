/*
 * @(#) TextSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-27
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Text, Shell, Display}
import org.eclipse.swt.SWT

object TextSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("文本框示例");
    val text1 = new Text(shell, SWT.NONE | SWT.BORDER); //带边框
    text1.setBounds(10, 10, 70, 30);
    val text2 = new Text(shell, SWT.PASSWORD); //密码样式
    text2.setBounds(90, 10, 70, 30);
    val text3 = new Text(shell, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL); // 多行、垂直、水平滚动条
    text3.setBounds(10, 50, 70, 70);
    val  text4 = new Text(shell, SWT.WRAP | SWT.V_SCROLL); //
    text4.setBounds(90, 50, 70, 70);
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      //如果主窗体没有关闭则一直循环
      if (!display.readAndDispatch()) {
        //如果display不忙
      }
    }
    shell.dispose()

  }
}
