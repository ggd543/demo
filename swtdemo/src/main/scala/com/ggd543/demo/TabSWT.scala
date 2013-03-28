/*
 * @(#) TabSWT.java
 * @Author:liuyongjian(liuyongjian@travelsky.com) 2013-03-28
 * @Copyright (c) 2002-2013 Travelsky Limited. All rights reserved.
 */
package com.ggd543.demo

import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT

object TabSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("选项卡示例");

    val tabFolder = new TabFolder(shell, SWT.NONE); //声明一个选项卡容器
    tabFolder.setBounds(5, 5, 180, 130);
    //设置选项卡的位置和大小
    val tabItem1 = new TabItem(tabFolder, SWT.NONE); //声明第1个选项页
    tabItem1.setText("选项1"); //设置选项页的标题
    {
      //创建第1个分组框，建立在tabFolder上
      val group1 = new Group(tabFolder, SWT.NONE);
      group1.setText("录入信息"); //设置分组框说明信息
      tabItem1.setControl(group1);
      //让tabItem1控制group1
      val lb1 = new Label(group1, SWT.NONE); //注意Label建立在group1上
      lb1.setText("姓名：");
      lb1.setBounds(10, 20, 70, 20);
      val text1 = new Text(group1, SWT.BORDER);
      text1.setBounds(90, 20, 70, 20);
      val lb2 = new Label(group1, SWT.NONE);
      lb2.setText("地址：");
      lb2.setBounds(10, 50, 70, 20);
      val text2 = new Text(group1, SWT.BORDER);
      text2.setBounds(90, 50, 70, 20);
    }
    val tabItem2 = new TabItem(tabFolder, SWT.NONE); //声明第2个选项页
    tabItem2.setText("选项2");
    {
      //创建第2个分组框，建立在tabFolder上
      val group2 = new Group(tabFolder, SWT.NONE);
      tabItem2.setControl(group2); //让tabItem2控制group2
      group2.setText("兴趣爱好");
      val bt1 = new Button(group2, SWT.CHECK);
      bt1.setBounds(20, 20, 70, 20);
      bt1.setText("音乐");
      val bt2 = new Button(group2, SWT.CHECK);
      bt2.setBounds(20, 50, 70, 20);
      bt2.setText("美术");
      val bt3 = new Button(group2, SWT.CHECK);
      bt3.setBounds(20, 80, 70, 20);
      bt3.setText("体育");
    }
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      //如果主窗体没有关闭则一直循环
      if (!display.readAndDispatch()) {
        //如果display不忙
        display.sleep();
      }
    }
    shell.dispose();
  }
}
