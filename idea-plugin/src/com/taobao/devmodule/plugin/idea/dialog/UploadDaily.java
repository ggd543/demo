package com.taobao.devmodule.plugin.idea.dialog;

import com.taobao.devmodule.plugin.idea.action.UploadDailyAction;

import javax.swing.*;
import java.awt.event.*;

public class UploadDaily extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton noCompressRadio;
    private JRadioButton compressRadio;
    private JTextArea summary;
    private JTextField protoTypeId;
    private JTextField shortName;
    private JTextField version;
    private boolean doAction;
    private boolean isCompress = false;

    public UploadDaily() {
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
                onCancel();
            }
        });


        noCompressRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                noCompress();
            }
        });

        compressRadio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compress();
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


    private void compress() {
        isCompress = true;
        noCompressRadio.setSelected(false);
    }

    private void noCompress() {
        isCompress = false;
        compressRadio.setSelected(false);
    }


    private void onOK() {
        doAction = true;
        dispose();
    }

    private void onCancel() {
        doAction = false;
        dispose();
    }

    public void setData(UploadDailyAction data) {
        summary.setText(data.getSummary());
        protoTypeId.setText(data.getProtoTypeId());
        shortName.setText(data.getShortName());
        version.setText(data.getVersion());
    }

    public void getData(UploadDailyAction data) {
        data.setSummary(summary.getText());
        data.setProtoTypeId(protoTypeId.getText());
        data.setShortName(shortName.getText());
        data.setVersion(version.getText());
        data.setDoAction(doAction);
        data.setCompress(isCompress);
    }

    public boolean isModified(UploadDailyAction data) {
        if (summary.getText() != null ? !summary.getText().equals(data.getSummary()) : data.getSummary() != null)
            return true;
        if (protoTypeId.getText() != null ? !protoTypeId.getText().equals(data.getProtoTypeId()) : data.getProtoTypeId() != null)
            return true;
        if (shortName.getText() != null ? !shortName.getText().equals(data.getShortName()) : data.getShortName() != null)
            return true;
        if (version.getText() != null ? !version.getText().equals(data.getVersion()) : data.getVersion() != null)
            return true;
        return false;
    }

    public void setOnLineInfo(){
        compressRadio.setText("压缩上线");
        noCompressRadio.setText("发布上线");
    }
}
