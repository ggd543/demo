package com.ggd543.demo.layout.formlayout

import org.eclipse.swt.widgets._
import org.eclipse.swt.layout._
import org.eclipse.swt.SWT

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-30
 * Time: 上午8:11
 * To change this template use File | Settings | File Templates.
 */
object FormLayout6 {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    shell.setText("FormLayout示例");

    val formlayout = new FormLayout(); //创建表格布局对象
    shell.setLayout(formlayout);
    val label = new Label(shell, SWT.BORDER); //在shell中创建Label对象
    label.setText("Label One");
    val data = new FormData();
    data.top = new FormAttachment(0, 5); //Label与shell上边框相距5象素
    data.left = new FormAttachment(0, 5); // Label与shell左边框相距5象素
    data.bottom = new FormAttachment(50, -5); //Label在shell水平中线上方5象素
    data.right = new FormAttachment(50, -5); // Label在shell垂直中线左边5象素
    label.setLayoutData(data);

    val composite = new Composite(shell, SWT.NONE);
    //创建面板
    val gridLayout = new GridLayout(); //创建网格布局对象
    gridLayout.marginHeight = 0;
    gridLayout.marginWidth = 0;
    composite.setLayout(gridLayout);
    //设置面板布局方式为网格布局
    val b1 = new Button(composite, SWT.PUSH); //在composite上创建button B1
    b1.setText("B1");
    val gridData1 = new GridData(GridData.FILL_BOTH); //设置布局方式为双向填充
    b1.setLayoutData(gridData1);

    val b2 = new Button(composite, SWT.PUSH); //B2设置同B1
    b2.setText("B2");
    val gridData2 = new GridData(GridData.FILL_BOTH);
    b2.setLayoutData(gridData2);

    val b3 = new Button(composite, SWT.PUSH); //B2设置同B1
    b3.setText("B3");
    val gridData3 = new GridData(GridData.FILL_BOTH);
    b3.setLayoutData(gridData3);

    val data2 = new FormData();    //创建FormData对象
    data2.top = new FormAttachment(0, 5);     //设置composite距shell上边框5象素
    data2.left = new FormAttachment(label, 5);//设置composite距label 5象素
    data2.bottom = new FormAttachment(50, -5);//设置composite在shell水平中线上方5象素
    data2.right = new FormAttachment(100, -5);//设置composite在shell右边框的左侧5象素
    composite.setLayoutData(data2);          //设置composite的布局数据

    val text=new Text(shell,SWT.BORDER);   //创建Text对象
    text.setText("Text");
    val data3 = new FormData();    //创建表格布局数据
    data3.top = new FormAttachment(label, 5);   //text上方离label 5象素
    data3.left = new FormAttachment(0, 5);      // text左边离shell左边框5象素
    data3.bottom = new FormAttachment(100, -5); // text下边框离shell下边框5象素
    data3.right = new FormAttachment(100, -5);  // text右边框离shell右边框5象素
    text.setLayoutData(data3);                  //设置text的布局数据

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
