package com.ggd543.demo.event

import org.eclipse.swt.widgets.{Text, Label, Shell, Display}
import org.eclipse.swt.SWT
import org.eclipse.swt.layout.{GridData, GridLayout}
import org.eclipse.swt.events.{KeyEvent, KeyAdapter}
import org.eclipse.swt.graphics.Color

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-30
 * Time: 上午9:34
 * To change this template use File | Settings | File Templates.
 */
object KeyboardEventSWT {

  def main(args: Array[String]): Unit = {
    val display = new Display();
    val shell = new Shell(display, SWT.SHELL_TRIM);
    val layout = new GridLayout();
    layout.numColumns = 2;
    shell.setLayout(layout);
    shell.setText("Event demo");


    val label1 = new Label(shell, SWT.RIGHT);
    label1.setText("text1:");
    val text1 = new Text(shell, SWT.BORDER | SWT.WRAP);
    val gridData1 = new GridData(100, 100);
    text1.setLayoutData(gridData1);

    val label2 = new Label(shell, SWT.RIGHT);
    label2.setText("text2:");
    val text2 = new Text(shell, SWT.BORDER | SWT.WRAP);
    val gridData2 = new GridData(100, 100);
    text2.setLayoutData(gridData2);
    text2.setEditable(false);
    text2.setBackground(new Color(display, 255, 255, 255));

    text1.addKeyListener(new KeyAdapter() {

      override def keyPressed(e: KeyEvent):Unit = {
        if (e.keyCode == SWT.CR) {
          text2.setText(text1.getText());
        }
      }
      override def keyReleased(e: KeyEvent): Unit = {
        //监听键盘按键
        if (e.keyCode == SWT.CR) {
          text1.setText("");
          text1.setFocus()
          text1.setSelection(0,0)


        }
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
