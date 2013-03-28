/*
 * @(#) FormLayout2.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.formlayout

import org.eclipse.swt.layout.FormLayout
import org.eclipse.swt.widgets.{Button, Shell, Display}
import org.eclipse.swt.SWT

object FormLayout2 {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    val layout = new FormLayout();

    layout.marginHeight = 5;
    layout.marginWidth = 10;
    shell.setLayout(layout);
    new Button(shell, SWT.PUSH).setText("Button");
    shell.pack()
    shell.open()

    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
    display.dispose();
  }
}
