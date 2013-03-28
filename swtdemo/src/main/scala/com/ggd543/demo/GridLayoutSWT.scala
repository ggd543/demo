/*
 * @(#) GridLayoutSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.{Button, Display, Shell}
import org.eclipse.swt.SWT

object GridLayoutSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    shell.setText("GridLayout示例");
    val gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    gridLayout.horizontalSpacing = 30;
    gridLayout.makeColumnsEqualWidth = true;
    shell.setLayout(gridLayout);
    new Button(shell, SWT.PUSH).setText("B1");
    new Button(shell, SWT.PUSH).setText("超宽按钮 2");
    new Button(shell, SWT.PUSH).setText("按钮 3");
    new Button(shell, SWT.PUSH).setText("B4");
    new Button(shell, SWT.PUSH).setText("按钮 5");
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch()) display.sleep();
    }
    display.dispose();
  }
}
