package demo;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-11-6
 * Time: 下午10:51
 * To change this template use File | Settings | File Templates.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Zhuce extends JFrame {
    public static void main(String[] args) {
        new Zhuce();
    }

    //创建面板JPanel
    private JPanel jp = new JPanel();

    //创建标签数组
    private JLabel[] jl = new JLabel[]{
            new JLabel("用户名"), new JLabel("密码"), new JLabel("确认密码"), new JLabel("电子邮件"), new JLabel("")
    };

    //创建文本框和密码框
    private JTextField jtName = new JTextField();
    private JPasswordField jpw1 = new JPasswordField();
    private JPasswordField jpw2 = new JPasswordField();
    private JTextField jtSure = new JTextField();

    //创建按钮数组
    private JButton[] jb = new JButton[]{
            new JButton("注册"), new JButton("清除")
    };

    //构造器
    public Zhuce() {
        AtLi al = new AtLi();
        //设置布局管理器,设置为空
        jp.setLayout(null);
        //对文本框进行处理
        jtName.setBounds(180, 60, 360, 60);
        //对齐方式
        //jtName.setHorizontalAlignment(JTextField.CENTER);
        jtSure.setBounds(180, 420, 360, 60);
        //添加到JPanel中
        jp.add(jtName);
        jp.add(jtSure);
        //注册监听器
        jtName.addActionListener(al);
        jtSure.addActionListener(al);

        //处理密码框
        jpw1.setBounds(180, 180, 360, 60);
        jpw1.setEchoChar('*');
        jpw2.setBounds(180, 300, 360, 60);
        jpw2.setEchoChar('*');
        //添加进JPanel
        jp.add(jpw1);
        jp.add(jpw2);
        //注册监听器
        jpw1.addActionListener(al);
        jpw2.addActionListener(al);

        //循环处理标签和按钮
        for (int i = 0; i < jl.length; i++) {
            if (i == jl.length - 1) {
                jl[i].setBounds(60, 0, 480, 60);
                //内容居中
                jl[i].setHorizontalAlignment(JLabel.CENTER);
                jp.add(jl[i]);

            } else {
                jl[i].setBounds(60, 60 + 120 * i, 120, 60);
                jl[i].setHorizontalAlignment(JLabel.CENTER);
                jp.add(jl[i]);
                //处理按钮
                if (i > 1) {
                    continue;
                }
                jb[i].setBounds(220 + i * 130, 480, 120, 60);
                jp.add(jb[i]);
                jb[i].addActionListener(al);

            }
        }
        //设置窗体
        this.add(jp);
        this.setBounds(100, 100, 600, 600);
        this.setTitle("用户注册");
        this.setVisible(true);
        this.setResizable(false);


    }

    public JTextField getjtName() {
        return this.jtName;
    }

    public JTextField getjtSure() {
        return this.jtSure;
    }

    public JPasswordField getjpw1() {
        return this.jpw1;
    }

    public JPasswordField getjpw2() {
        return this.jpw2;
    }

    public JButton getbt1() {
        return this.jb[0];
    }

    public JButton getbt2() {
        return this.jb[1];
    }

    public JLabel getjl4() {
        return this.jl[4];
    }


    public class AtLi implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jtName) {
                //文本框获得焦点
                jtName.requestFocus();
            } else if (e.getSource() == jtSure) {
                jtSure.requestFocus();
            } else if (e.getSource() == jpw1) {
                jpw1.requestFocus();
            } else if (e.getSource() == jpw2) {
                jpw2.requestFocus();
            } else if (e.getSource() == jb[1]) {
                jl[4].setText("");
                jtName.setText("");
                jtSure.setText("");
                jpw1.setText("");
                jpw2.setText("");
                jtName.requestFocus();
            } else if (e.getSource() == jb[0]) {
                //创建临时String对象接收jtSure邮件框的文本
                String str = jtSure.getText();
                //转换为字符
                char[] ch = str.toCharArray();
                //判断是否有‘@’字符
                boolean b = false;
                for (int i = 0; i < ch.length; i++) {
//					System.out.println(ch[i]);
                    if (ch[i] == '@') {
                        b = true;
                    }
                }

                //getPassword()返回密码框中的文本放回类型为ch
                if (jpw1.getPassword().length < 6) {
                    jl[4].setText("密码长度不能小于6位。。");
                    jpw1.requestFocus();
                } else if (jpw1.getPassword().length != jpw2.getPassword().length) {
                    jl[4].setText("两次密码不一致！！");
                    jpw2.requestFocus();
                } else if (str.length() == 0) {
                    jl[4].setText("邮箱不能为空");
                } else if (b == false) {
                    jl[4].setText("邮箱格式不对，必需有@！！");
                } else {
                    jl[4].setText("注册成功！！");
                }

            }

        }
    }

}
