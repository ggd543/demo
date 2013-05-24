package com.ggd543.idea.plugin.component;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.ComponentManager;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-5
 * Time: 下午6:47
 * To change this template use File | Settings | File Templates.
 */
public class MyApplicationComponent implements ApplicationComponent {
    @Override
    public void initComponent() {
        System.out.println("MyApplicationComponent.initComponent");
    }

    @Override
    public void disposeComponent() {
        System.out.println("MyApplicationComponent.disposeComponent");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "MyApplicationComponent";
    }
}
