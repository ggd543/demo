package com.ggd543.idea.plugin.action;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-4-5
 * Time: 下午4:30
 * To change this template use File | Settings | File Templates.
 */
public class TextBoxAction extends AnAction {
    public TextBoxAction() {
    }

    public TextBoxAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here'
        System.out.println("ActionManager: " + e.getActionManager());
        displayTemplate(e);
        Project project = e.getData(PlatformDataKeys.PROJECT);
        String txt = Messages.showInputDialog(project, "What is your name?", "Input your name", Messages.getQuestionIcon());
        Messages.showMessageDialog(project, "Hello, " + txt + "!\n I am glad to see you.", "Information", Messages.getInformationIcon());
    }

    private void displayTemplate(AnActionEvent e) {
        Presentation presentation = getTemplatePresentation();
        System.out.println("---- presentation ----");
        System.out.println("text: " + presentation.getText());
        System.out.println("icon: " + presentation.getIcon());
        System.out.println("description: " + presentation.getDescription());
        System.out.println("----------------------");
    }

    @Override
    public void update(AnActionEvent e) {
//        Presentation presentation = getTemplatePresentation();
//        System.out.println(presentation.getText() + " " + Thread.currentThread());
    }
}
