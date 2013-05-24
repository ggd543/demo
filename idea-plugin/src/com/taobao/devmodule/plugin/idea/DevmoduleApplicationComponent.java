package com.taobao.devmodule.plugin.idea;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.util.DefaultJDOMExternalizer;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizable;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: buan.hs
 * Date: 2010-12-14
 * Time: 14:58:36
 * To change this template use File | Settings | File Templates.
 */
public class DevmoduleApplicationComponent implements ApplicationComponent, Configurable, JDOMExternalizable {
    public String onLineServerURL = "";
    public String localDataFilePath = "";
    public String testServerURL = "";
    private ServerForm form;

    public DevmoduleApplicationComponent() {
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "DevmoduleApplicationComponent";
    }

    public String getOnLineServerURL() {
        return onLineServerURL;
    }

    public void setOnLineServerURL(final String onLineServerURL) {
        this.onLineServerURL = onLineServerURL;
    }

    public String getLocalDataFilePath() {
        return localDataFilePath;
    }

    public void setLocalDataFilePath(final String localDataFilePath) {
        this.localDataFilePath = localDataFilePath;
    }

    @Nls
    public String getDisplayName() {
        return "ModulePlugin";
    }

    public Icon getIcon() {
        return null;
    }

    public String getHelpTopic() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void readExternal(Element element) throws InvalidDataException {
        DefaultJDOMExternalizer.readExternal(this, element);
    }

    public void writeExternal(Element element) throws WriteExternalException {
        DefaultJDOMExternalizer.writeExternal(this, element);
    }

    public JComponent createComponent() {
        if (form == null) {
            form = new ServerForm();
        }
        return form.getRootComponent();
    }

    public boolean isModified() {
        return form != null && form.isModified(this);
    }

    public void apply() throws ConfigurationException {
        if (form != null) {
            form.getData(this);
        }
    }

    public void reset() {
        if (form != null) {
            form.setData(this);
        }
    }

    public void disposeUIResources() {
        form = null;
    }

    public String getTestServerURL() {
        return testServerURL;
    }

    public void setTestServerURL(final String testServerURL) {
        this.testServerURL = testServerURL;
    }
}
