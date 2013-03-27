/*
 * @(#) LabelSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-27
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Label, Display, Shell}
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Font

object LabelSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display()
    val shell = new Shell(display)
    shell.setText("标签示例")
    val lb1 = new Label(shell, SWT.BORDER | SWT.RIGHT) // 深陷型、文字右对齐
    lb1.setBounds(10, 10, 70, 30)
    lb1.setFont(new Font(display, "黑体", 14, SWT.BOLD)) // 黑体，14磅，粗体
    lb1.setText("标签1")
    lb1.setForeground(Display.getCurrent.getSystemColor(SWT.COLOR_BLUE)) // 设置前景色
    val lb2 = new Label(shell, SWT.CENTER) // 居中
    lb2.setFont(new Font(display, "宋体", 14, SWT.ITALIC)) // 宋体、14磅、斜体
    lb2.setForeground(Display.getCurrent.getSystemColor(SWT.COLOR_RED))
    lb2.setText("标签2")
    lb2.setBounds(90, 10, 70, 30)
    val lb3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.BORDER)
    lb3.setBounds(10, 50, 70, 30)
    lb3.setText("标签3") // 无效
    val lb4 = new Label(shell, SWT.SEPARATOR | SWT.BORDER)
    lb4.setBounds(90, 50, 70, 30)

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

  }
}
