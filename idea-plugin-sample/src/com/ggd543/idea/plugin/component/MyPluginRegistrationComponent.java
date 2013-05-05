package com.ggd543.idea.plugin.component;

import com.ggd543.idea.plugin.action.TextBoxAction;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-5
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
public class MyPluginRegistrationComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        ActionManager am = ActionManager.getInstance();
        TextBoxAction action = new TextBoxAction("My_Item","This is a sample item" , IconLoader.getIcon("/icon/setting.png"));
        // Passes an instance of your custom TextBoxes class to the registerAction method of the ActionManager class.
        am.registerAction("MyPluginAction", action);
        // Gets an instance of the WindowMenu action group.
        DefaultActionGroup windowM = (DefaultActionGroup) am.getAction("WindowMenu");
        // Adds a separator and a new menu command to the WindowMenu group on the main menu.
        windowM.addSeparator();
        windowM.add(action);
    }

    @Override
    public void disposeComponent() {
        System.out.println("MyPluginAction.disposeComponent");
    }

    @NotNull
    @Override
    public String getComponentName() {
        return "MyPluginRegistration";
    }
}
