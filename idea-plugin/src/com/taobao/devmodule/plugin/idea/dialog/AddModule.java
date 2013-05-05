package com.taobao.devmodule.plugin.idea.dialog;

import com.taobao.devmodule.plugin.idea.action.AddModuleAction;

import javax.swing.*;
import java.awt.event.*;

public class AddModule extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField protoTypeId;
    private JTextField shortName;
    private JTextField version;
    private JRadioButton yesRadio;
    private JRadioButton noRadio;
    private boolean doAction;

    public AddModule() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
                onCancel();
            }
        });

        yesRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                     clickYesRadio();
            }
        });


        noRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                     clickNoRadio();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }


    private void clickYesRadio() {
        this.noRadio.setSelected(false);
    }

    private void clickNoRadio() {
        this.yesRadio.setSelected(false);
    }

    private void onOK() {
        doAction = true;
        dispose();
    }

    private void onCancel() {
        doAction = false;
        dispose();
    }


    public void setData(AddModuleAction data) {
        protoTypeId.setText(data.getProtoTypeId());
        shortName.setText(data.getShortName());
        version.setText(data.getVersion());
    }

    public void getData(AddModuleAction data) {
        data.setProtoTypeId(protoTypeId.getText());
        data.setShortName(shortName.getText());
        data.setVersion(version.getText());
        data.setDoAction(doAction);
        if (this.yesRadio.isSelected()) {
            data.setCleanCache(true);
        } else {
            data.setCleanCache(false);
        }

    }

    public boolean isModified(AddModuleAction data) {
        if (protoTypeId.getText() != null ? !protoTypeId.getText().equals(data.getProtoTypeId()) : data.getProtoTypeId() != null)
            return true;
        if (shortName.getText() != null ? !shortName.getText().equals(data.getShortName()) : data.getShortName() != null)
            return true;
        if (version.getText() != null ? !version.getText().equals(data.getVersion()) : data.getVersion() != null)
            return true;
        return false;
    }
}
