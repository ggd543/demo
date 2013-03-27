/*
 * @(#) ButtonSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-27
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Button, Shell, Display}
import org.eclipse.swt.SWT

object ButtonSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display)
    shell.setText("按钮示例") // 设置主窗体标题
    val btn = new Button(shell, SWT.NULL) // 默认按钮
    btn.setText("SWT.NULL") // 按钮上的文字
    btn.setBounds(10, 10, 75, 30) // 设置按钮的坐标和宽高
    val btn2 = new Button(shell, SWT.PUSH | SWT.BORDER) // 创建深陷型按钮
    btn2.setText("SWT.PUSH")
    btn2.setBounds(90, 10, 75, 30)
    val check1 = new Button(shell, SWT.CHECK) // 复选框按钮
    check1.setText("SWT.CHECK")
    check1.setBounds(10, 50, 75, 30)
    val check2 = new Button(shell, SWT.CHECK | SWT.BORDER)
    check2.setText("SWT.CHECK|BORDER")
    check2.setBounds(90, 50, 75, 30)
    val radio1 = new Button(shell, SWT.RADIO)
    radio1.setText("SWT.RADIO")
    radio1.setBounds(10, 90, 75, 30)
    shell.pack()
    shell.open()
    while (!shell.isDisposed) {
      // 如果主窗体没有关闭
      if (!display.readAndDispatch()) {
        // 如果display不忙
        display.sleep() // 休眠
      }
    }
    display.dispose() // 销毁display
    println("...")
  }
}
