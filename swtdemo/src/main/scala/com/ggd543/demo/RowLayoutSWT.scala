/*
 * @(#) RowLayoutSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets.{Button, Shell, Display}
import org.eclipse.swt.layout.{RowData, RowLayout}
import org.eclipse.swt.SWT

object RowLayoutSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("FillLayout示例");
    val rowlayout = new RowLayout(); //创建按行放置组件的对象
    rowlayout.pack = false; //强制组件大小相同
    rowlayout.wrap = false; //不自动折行
    rowlayout.marginWidth = 2; //组件距容器边缘的宽度为20像素
    rowlayout.marginHeight = 20; //组件距容器边缘的高度为20像素
    rowlayout.marginLeft = 100
    rowlayout.spacing = 10; //组件之间的间距为10像素
    shell.setLayout(rowlayout);
    //设置容器shell的布局方式为rowlayout
    val bt1 = new Button(shell, SWT.PUSH); //创建按钮
    bt1.setText("按钮1");
    val rowdata = new RowData(80, 30); //创建布局数据类的对象
    bt1.setLayoutData(rowdata); //设置按钮的布局数据
    new Button(shell, SWT.PUSH).setText("按钮2");
    new Button(shell, SWT.PUSH).setText("按钮3");
    new Button(shell, SWT.PUSH).setText("按钮4");

    shell.pack();       //自动调整容器shell的大小
    shell.open();       //打开主窗体
    while(!shell.isDisposed()){  //如果主窗体没有关闭则一直循环
      if(!display.readAndDispatch()){  //如果display不忙
        display.sleep();    //休眠
      }
    }
    display.dispose();      //销毁display
  }
}
