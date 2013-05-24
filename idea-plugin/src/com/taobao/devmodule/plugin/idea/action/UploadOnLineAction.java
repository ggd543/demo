package com.taobao.devmodule.plugin.idea.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.taobao.devmodule.plugin.idea.dialog.UploadDaily;

/**
 * Created by IntelliJ IDEA.
 * User: buan.hs
 * Date: 2010-12-15
 * Time: 16:19:10
 * To change this template use File | Settings | File Templates.
 */
public class UploadOnLineAction extends UploadDailyAction {

    public void actionPerformed(AnActionEvent e) {
        UploadDaily dialog = new UploadDaily();
        dialog.pack();
        dialog.setTitle("模块上传到线上环境");
        dialog.setOnLineInfo();
        dialog.setLocation(450, 450);
        dialog.setSize(400, 300);
        dialog.setVisible(true);
        dialog.getData(this);

        if (doAction) {
            System.out.println("go  online...");
        } else {
            System.out.println("nothing  online...");
        }
    }
}
