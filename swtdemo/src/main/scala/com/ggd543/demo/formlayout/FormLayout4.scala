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
    formData.left = new FormAttachment(0, 10)
    formData.right = new FormAttachment(100, -50);
    formData.top = new FormAttachment(1, 4, 0);
    button.setLayoutData(formData);

    val button2 = new Button(shell, SWT.PUSH)
    button2.setText("Button 2")
    val formData2 = new FormData();
    formData2.top = new FormAttachment(button, 5)
    formData2.left = new FormAttachment(button, 0, SWT.LEFT)
    formData2.right = new FormAttachment(button, 0, SWT.RIGHT)
    button2.setLayoutData(formData2)

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
