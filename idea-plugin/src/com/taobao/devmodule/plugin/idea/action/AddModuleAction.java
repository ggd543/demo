package com.taobao.devmodule.plugin.idea.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.taobao.devmodule.plugin.idea.DevmoduleApplicationComponent;
import com.taobao.devmodule.plugin.idea.dialog.AddModule;

/**
 * Created by IntelliJ IDEA.
 * User: buan.hs
 * Date: 2010-12-15
 * Time: 10:34:40
 * To change this template use File | Settings | File Templates.
 */
public class AddModuleAction extends AnAction {
    private String protoTypeId;
    private String shortName;
    private String version;
    private boolean doAction;
    private boolean cleanCache;

    public void actionPerformed(AnActionEvent e) {
        AddModule dialog = new AddModule();
        dialog.pack();
        dialog.setTitle("DC create module");
        dialog.setLocation(450, 450);
        dialog.setVisible(true);
        dialog.getData(this);
        DevmoduleApplicationComponent application = ApplicationManager.getApplication().getComponent(DevmoduleApplicationComponent.class);
        System.out.println("abc:" + application.getOnLineServerURL());
        if (doAction) {
            System.out.println(protoTypeId);
            System.out.println(shortName);
            System.out.println(version);
        }
        VirtualFile[] files = (VirtualFile[]) e.getDataContext().getData(DataConstants.VIRTUAL_FILE_ARRAY);
        for (int i = 0; i < files.length; i++) {
            VirtualFile vf = files[i];

            System.out.println(vf.getPath());
            try {
                String temp = com.intellij.openapi.vfs.VfsUtil.loadText(vf);
                System.out.println(temp);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
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

    public void setCleanCache(boolean cleanCache) {
        this.cleanCache = cleanCache;
    }


    public void setDoAction(boolean doAction) {
        this.doAction = doAction;
    }
}
