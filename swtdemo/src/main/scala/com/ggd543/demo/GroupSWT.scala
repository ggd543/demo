/*
 * @(#) GroupSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT

object  GroupSWT {
def main(args: Array[String]):Unit={
  val display=new Display();//创建一个display对象。
  val shell=new Shell(display);//shell是程序的主窗体
  shell.setText("分组框示例");

  val group1=new Group(shell,SWT.NONE); //创建分组框
  group1.setText("录入信息");            //设置分组框说明信息
  group1.setBounds(10,20,200,100);
  val lb1=new Label(group1,SWT.NONE);  //在分组框中加入组件
  lb1.setText("姓名：");
  lb1.setBounds(10,20,70,20);
  val text1=new Text(group1,SWT.BORDER);
  text1.setBounds(90,20,70,20);
  val lb2=new Label(group1,SWT.NONE);
  lb2.setText("地址：");
  lb2.setBounds(10,50,70,20);
  val text2=new Text(group1,SWT.BORDER);
  text2.setBounds(90,50,70,20);
  shell.pack();
  shell.open();

  while(!shell.isDisposed()){  //如果主窗体没有关闭则一直循环
    if(!display.readAndDispatch()){  //如果display不忙
      display.sleep();    //休眠
    }
  }
  display.dispose();      //销毁display
}
}
