package com.taobao.devmodule.plugin.idea.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.taobao.devmodule.plugin.idea.dialog.UploadDaily;

/**
 * Created by IntelliJ IDEA.
 * User: buan.hs
 * Date: 2010-12-15
 * Time: 16:18:40
 * To change this template use File | Settings | File Templates.
 */
public class UploadDailyAction extends AnAction {
    private String summary;
    private String protoTypeId;
    private String shortName;
    private String version;
    protected boolean doAction;
    protected boolean isCompress;


    public void actionPerformed(AnActionEvent e) {
        UploadDaily dialog = new UploadDaily();
        dialog.pack();
        dialog.setTitle("模块上传到日常环境");
        dialog.setLocation(450, 450);
        dialog.setSize(400,300);
        dialog.setVisible(true);
        dialog.getData(this);

        if (doAction) {
            System.out.println("go...");
        } else {
            System.out.println("nothing...");
        }
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(final String summary) {
        this.summary = summary;
    }

    public String getProtoTypeId() {
        return protoTypeId;
    }

    public void setProtoTypeId(final String protoTypeId) {
        this.protoTypeId = protoTypeId;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(final String shortName) {
        this.shortName = shortName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public void setDoAction(boolean doAction) {
        this.doAction = doAction;
    }

    public void setCompress(boolean compress) {
        isCompress = compress;
    }
}

