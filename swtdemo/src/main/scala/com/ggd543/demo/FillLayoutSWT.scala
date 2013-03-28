/*
 * @(#) FillLayoutSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.layout.FillLayout
import org.eclipse.swt.widgets.{Button, Display, Shell}
import org.eclipse.swt.SWT

object FillLayoutSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("FillLayout示例");
    val filllayout = new FillLayout(SWT.VERTICAL); //创建FillLayout对象
    shell.setLayout(filllayout); //将FillLayout对象用于shell上
    new Button(shell, SWT.PUSH).setText("超宽按钮1"); //在shell中创建按钮
    new Button(shell, SWT.PUSH).setText("按钮2");
    new Button(shell, SWT.PUSH).setText("按钮3");
    new Button(shell, SWT.PUSH).setText("按钮4");
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      //如果主窗体没有关闭则一直循环
      if (!display.readAndDispatch()) {
        //如果display不忙
        display.sleep(); //休眠
      }
    }
    display.dispose(); //销毁display
  }
}
