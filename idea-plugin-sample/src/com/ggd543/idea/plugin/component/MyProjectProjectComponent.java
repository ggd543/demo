package com.ggd543.idea.plugin.component;

import com.intellij.openapi.components.ProjectComponent;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-5
 * Time: 下午6:52
 * To change this template use File | Settings | File Templates.
 */
public class MyProjectProjectComponent implements ProjectComponent {
    @Override
    public void projectOpened() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void projectClosed() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void initComponent() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void disposeComponent() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @NotNull
    @Override
    public String getComponentName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
