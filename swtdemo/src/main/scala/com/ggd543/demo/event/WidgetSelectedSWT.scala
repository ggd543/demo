package com.ggd543.demo.event

import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.{MessageBox, Button, Shell, Display}
import org.eclipse.swt.layout.{RowData, RowLayout}
import org.eclipse.swt.events.{SelectionEvent, SelectionAdapter}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-30
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
object WidgetSelectedSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display()
    val shell = new Shell(display, SWT.SHELL_TRIM)
    shell.setText("组件选择事件示例");
    val layout = new RowLayout();
    layout.marginHeight = 10;
    layout.marginWidth = 20;
    shell.setLayout(layout);

    val button = new Button(shell, SWT.PUSH);
    button.setText("请点击我");
    val data = new RowData(80, 40);
    button.setLayoutData(data);
    button.addSelectionListener(new SelectionAdapter() {
      override def  widgetSelected(e:SelectionEvent):Unit = {
        val dialog = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
        dialog.setText("组件选择事件");
        dialog.setMessage("你好，SWT世界！");
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
