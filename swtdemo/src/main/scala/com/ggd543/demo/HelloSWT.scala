/*
 * @(#) HelloSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-27
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Text, Shell, Display}
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Color

object HelloSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display() // 创建一个display对象
    val shell = new Shell(display) // shell 是程序的主窗体
    shell.setLayout(null) // 设置shell的布局方式
    val text = new Text(shell, SWT.MULTI) // 声明一个可以显示多行信息的文本框
    shell.setText("Scala应用程序") // 设置主窗体的标题
    shell.setSize(200, 100) // 设置窗口大小
    val color = new Color(Display.getCurrent, 255, 255, 255) // 定义颜色对象
    shell.setBackground(color) // 设置主窗体背景
    text.setText("Hello, SWT World\n\n你好, SWT世界") //  添加文本框信息
    text.pack() //自动调整文本框的大小
//    shell.pack() // 自动调整主窗体的大小
    shell.open(); // 打开主窗体
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
