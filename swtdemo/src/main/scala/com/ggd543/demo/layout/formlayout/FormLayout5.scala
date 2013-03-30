package com.ggd543.demo.layout.formlayout

import org.eclipse.swt.widgets.{Button, Shell, Display}
import org.eclipse.swt.layout.{FormAttachment, FormData, FormLayout}
import org.eclipse.swt.SWT

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-30
 * Time: 上午7:55
 * To change this template use File | Settings | File Templates.
 */
object FormLayout5 {
def main(args:Array[String]):Unit={
   val display = new Display()
  val shell = new Shell (display);
  shell.setText("FormLayout示例");

  val formlayout= new FormLayout();
  formlayout.marginHeight=10;     //设置shell的上、下边缘和组件的距离为10像素
  val b1=new Button(shell,SWT.PUSH);
  b1.setText("B1");
  val formData1=new FormData();  //创建布局数据对象formData1
  formData1.top=new FormAttachment(0,50);      //设置组件B1的顶部离父容器shell上边缘的距离为50像素
  formData1.bottom=new FormAttachment(100,-50);//设置组件B1的底部离shell的下边缘的距离为50像素
  formData1.left=new FormAttachment(0,50);     //设置组件B1的左边离shell的左边距离为50像素
  formData1.right=new FormAttachment(100,-50); //设置组件B1的右边离shell的右边距离为50像素
  formData1.width=100;     //按钮b1的宽度为100像素
  formData1.height=50;     //按钮b1的高度为50像素
  b1.setLayoutData(formData1);  //设置b1的布局数据为formData1

  val b2=new Button(shell,SWT.PUSH);
  b2.setText("B2");
  val formAttachment=new FormAttachment();//创建FormAttachment对象
  val formData2=new FormData(50,30);  //创建FormData对象，宽度50，高度30
  formData2.left=formAttachment;  //B2的左边与shell左边缘的距离为0
  formData2.top=formAttachment;   //B2的上边与shell上边缘的距离为marginHeight设定的值（10像素）
  b2.setLayoutData(formData2);    //设置b2的布局数据为formData2
  shell.setLayout(formlayout);

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
