/*
 * @(#) CompositeSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Label, Composite, Shell, Display}
import org.eclipse.swt.SWT

object CompositeSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("容器示例");

    val composite1 = new Composite(shell, SWT.NONE);
    composite1.setBounds(10, 10, 100, 50);
    val composite2 = new Composite(shell, SWT.BORDER);
    composite2.setBounds(120, 10, 100, 50);

    val lb1 = new Label(composite1, SWT.NONE);
    lb1.setText("面板1");
    lb1.pack();
    val lb2 = new Label(composite2, SWT.NONE);
    lb2.setText("面板2");

    lb2.pack();
    shell.pack();
    shell.open();

    while (!shell.isDisposed()) {
      //如果主窗体没有关闭则一直循环
      if (!display.readAndDispatch()) {
        //如果display不忙
        display.sleep(); //休眠
      }
    }
    display.dispose(); //销毁displ
  }
}
