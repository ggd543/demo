package com.ggd543.demo.event

import org.eclipse.swt.widgets.{MessageBox, Text, Shell, Display}
import org.eclipse.swt.layout.{RowData, RowLayout}
import org.eclipse.swt.SWT
import org.eclipse.swt.events.{MouseEvent, MouseAdapter}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-30
 * Time: 上午8:59
 * To change this template use File | Settings | File Templates.
 */
object MouseEventSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display);
    val rowLayout = new RowLayout();
    rowLayout.marginWidth = 20;
    rowLayout.marginHeight = 30;
    shell.setLayout(rowLayout);
    shell.setText("SWT事件处理示例");
    val text = new Text(shell, SWT.BORDER | SWT.WRAP);
    val rowData = new RowData();
    rowData.width = 100;
    rowData.height = 50;
    text.setLayoutData(rowData);
    //将鼠标监听器用于text组件
    text.addMouseListener(new MouseAdapter() {
      //采用鼠标监听适配器
      override def mouseDoubleClick(e: MouseEvent): Unit = {
        //监听鼠标双击事件的方法
        text.setText("文本框中鼠标双击事件发生！"); //在text中显示信息
        //声明信息对话框对象，并在对话框中显示信息
        val dialog = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
        dialog.setText("Double click");
        dialog.setMessage("文本框中鼠标双击事件发生！");
        dialog.open();
      }
    });

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
