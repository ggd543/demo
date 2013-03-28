/*
 * @(#) FormLayout3.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.formlayout

import org.eclipse.swt.widgets.{Button, Shell, Display}
import org.eclipse.swt.layout.{FormAttachment, FormData, FormLayout}
import org.eclipse.swt.SWT

object FormLayout4 {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    val layout = new FormLayout();
    shell.setLayout(layout)

    val button = new Button(shell, SWT.PUSH);
    button.setText("Button");
    val formData = new FormData();

    formData.height = 50;
    formData.width = 50;
    formData.right = new FormAttachment(50, 0);
//    formData.left = new FormAttachment(0,10)
    button.setLayoutData(formData);

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
