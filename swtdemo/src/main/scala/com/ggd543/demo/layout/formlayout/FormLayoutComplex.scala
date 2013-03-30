/*
 * @(#) FormLayoutComplex.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-29
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo.layout.formlayout

import org.eclipse.swt.widgets.{Composite, Button, Shell, Display}
import org.eclipse.swt.layout._
import org.eclipse.swt.SWT

object FormLayoutComplex {
 def main(args: Array[String]):Unit={
   val display = new Display();
   val shell = new Shell(display);

   val  layout = new FormLayout();
   shell.setLayout(layout);
   val one = new Button(shell, SWT.PUSH);
   one.setText("One");
   val data = new FormData();
   data.top = new FormAttachment(0, 5);
   data.left = new FormAttachment(0, 5);
   data.bottom = new FormAttachment(50, -5);
   data.right = new FormAttachment(50, -5);
   one.setLayoutData(data);

   val  composite = new Composite(shell, SWT.NONE);
   val gridLayout = new GridLayout();
   gridLayout.marginHeight = 0;
   gridLayout.marginWidth = 0;
   composite.setLayout(gridLayout);
   val two = new Button(composite, SWT.PUSH);
   two.setText("two");
   val gridData2 = new GridData(GridData.FILL_BOTH);
   two.setLayoutData(gridData2);
   val three = new Button(composite, SWT.PUSH);
   three.setText("three");
   val gridData3 = new GridData(GridData.FILL_BOTH);
   three.setLayoutData(gridData3);
   val four = new Button(composite, SWT.PUSH);
   four.setText("four");
   val gridData4 = new GridData(GridData.FILL_BOTH);
   four.setLayoutData(gridData4);

   val _data = new FormData();
   _data.top = new FormAttachment(0, 5);
   _data.left = new FormAttachment(one, 5);
   _data.bottom = new FormAttachment(50, -5);
   _data.right = new FormAttachment(100, -5);
   composite.setLayoutData(_data);

   val five = new Button(shell, SWT.PUSH);
   five.setText("five");
   val data5 = new FormData();
   data5.top = new FormAttachment(one, 5);
   data5.left = new FormAttachment(0, 5);
   data5.bottom = new FormAttachment(100, -5);
   data5.right = new FormAttachment(100, -5);
   five.setLayoutData(data5);

   shell.pack();
   shell.open();
   while (!shell.isDisposed()) {
     if (!display.readAndDispatch()) {
       display.sleep();
     }
   }
   display.dispose();
 }

}
