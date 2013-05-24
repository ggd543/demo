package com.taobao.devmodule.plugin.idea;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: buan.hs
 * Date: 2010-12-14
 * Time: 14:59:06
 * To change this template use File | Settings | File Templates.
 */
public class ServerForm {
    private JTextField testServerURL;
    private JTextField onLineServerURL;
    private JTextField localDataFilePath;
    private JPanel rootComponent;

    public void setData(DevmoduleApplicationComponent data) {
        testServerURL.setText(data.getTestServerURL());
        onLineServerURL.setText(data.getOnLineServerURL());
        localDataFilePath.setText(data.getLocalDataFilePath());
    }

    public void getData(DevmoduleApplicationComponent data) {
        data.setTestServerURL(testServerURL.getText());
        data.setOnLineServerURL(onLineServerURL.getText());
        data.setLocalDataFilePath(localDataFilePath.getText());
    }

    public boolean isModified(DevmoduleApplicationComponent data) {
        if (testServerURL.getText() != null ? !testServerURL.getText().equals(data.getTestServerURL()) : data.getTestServerURL() != null)
            return true;
        if (onLineServerURL.getText() != null ? !onLineServerURL.getText().equals(data.getOnLineServerURL()) : data.getOnLineServerURL() != null)
            return true;
        if (localDataFilePath.getText() != null ? !localDataFilePath.getText().equals(data.getLocalDataFilePath()) : data.getLocalDataFilePath() != null)
            return true;
        return false;
    }

    public JComponent getRootComponent() {
        return rootComponent;
    }
}
