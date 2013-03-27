package com.ggd543.demo

import org.eclipse.swt.widgets._
import org.eclipse.swt.SWT
import org.eclipse.swt.events.{SelectionEvent, SelectionAdapter}

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-3-28
 * Time: 上午7:18
 * To change this template use File | Settings | File Templates.
 */
object MenuSWT {
  def main(args: Array[String]): Unit = {
    val display = new Display();
    //创建一个display对象。
    val shell = new Shell(display); //shell是程序的主窗体
    shell.setText("菜单示例");
    val mainMenu = new Menu(shell, SWT.BAR);
    shell.setMenuBar(mainMenu);
    //Menu mainMenu=new Menu(shell,SWT.POP_UP); //创建弹出式菜单
    //shell.setMenu(mainMenu);   //创建弹出式菜单
    {
      //"文件"项
      val fileItem = new MenuItem(mainMenu, SWT.CASCADE);
      fileItem.setText("文件&F");
      //"文件"菜单
      val fileMenu = new Menu(shell, SWT.DROP_DOWN);
      fileItem.setMenu(fileMenu);
      {
        //"新建"项
        val newFileItem = new MenuItem(fileMenu, SWT.CASCADE);
        newFileItem.setText("新建&N");
        //"新建"菜单
        val newFileMenu = new Menu(shell, SWT.DROP_DOWN);
        newFileItem.setMenu(newFileMenu);
        {
          //"新建项目"项
          val newProjectItem = new MenuItem(newFileMenu, SWT.PUSH);
          newProjectItem.setText("项目\tCtrl+Shift+N");
          //设置快捷键
          newProjectItem.setAccelerator(SWT.CTRL + SWT.SHIFT + 'N');
          //添加事件监听
          newProjectItem.addSelectionListener(new SelectionAdapter() {
            override def  widgetSelected( e:SelectionEvent):Unit= {
              val text = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP);
              text.setBounds(10, 10, 100, 30);
              text.setText("你选择了“新建项目”");
            }
          });
          new MenuItem(newFileMenu, SWT.SEPARATOR);
          new MenuItem(newFileMenu, SWT.PUSH).setText("包");
          new MenuItem(newFileMenu, SWT.PUSH).setText("类");
        }
        val openFileItem = new MenuItem(fileMenu, SWT.CASCADE);
        openFileItem.setText("打开&O");
        val exitItem = new MenuItem(fileMenu, SWT.CASCADE);
        exitItem.setText("退出&E");
      }
      val helpItem = new MenuItem(mainMenu, SWT.CASCADE);
      helpItem.setText("帮助&H");
    }

    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      //如果主窗体没有关闭则一直循环
      if (!display.readAndDispatch()) {
        //如果display不忙
        display.sleep(); //休眠
      }
    }
    display.dispose(); //销毁displa
  }
}