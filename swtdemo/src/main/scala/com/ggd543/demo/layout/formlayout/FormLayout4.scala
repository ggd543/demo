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
    val display = new Display ();
    val shell = new Shell (display);
    shell.setText("FormLayout示例");

    val formLayout= new FormLayout();  //创建表格布局对象formLayout
    shell.setLayout(formLayout);        //设置shell的布局方式为表格布局
    formLayout.marginHeight = 10;       //设置shell的上下边距为10像素
    formLayout.marginWidth = 20;        //设置shell的左右边距为10像素
    val b1=new Button(shell,SWT.PUSH);
    b1.setText("B1");
    val formData1=new FormData();  //创建布局数据对象formData1
    formData1.width=100;     //按钮b1的宽度为100像素
    formData1.height=50;     //按钮b1的高度为50像素
    b1.setLayoutData(formData1);  //设置b1的布局数据为formData1

    val b2=new Button(shell,SWT.PUSH);
    b2.setText("B2");
    //创建FormAttachment对象formAttachment,以b1为参照物
    val formAttachment=new FormAttachment(b1); //指定B1为参照物
    val formData2=new FormData(50,30);  //创建FormData对象，宽度50，高度30
    formData2.left=formAttachment;  //b2的左边紧贴与b1的右边
    b2.setLayoutData(formData2);    //设置b2的布局数据为formData2

    val b3=new Button(shell,SWT.PUSH);
    b3.setText("B3");
    val formData3=new FormData();//创建布局数据对象formData3
    formData3.top=new FormAttachment(b2,10,SWT.BOTTOM);//b2的底边与b3的顶部距离为10
    formData3.left=new FormAttachment(b2,0,SWT.LEFT);//b2的左边与b3左边位移为0， 即左边对齐
    formData3.right=new FormAttachment(b2,0,SWT.RIGHT);  //b2的右边与b3右边对齐
    b3.setLayoutData(formData3); //设置b3的布局数据为formData3

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
