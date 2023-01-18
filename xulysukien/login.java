package xulysukien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import view.viewlogin;
import ketnoisql.sql;


public class login extends JFrame {

    login() {

       viewlogin v = new viewlogin();
       sql s = new sql();

        v.showpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == v.showpass) {
                    if (v.showpass.getText().equals("SHOW PASS")) {
                        v.showpass.setText("HIDE PASS");
                        v.jpass.setEchoChar((char)0);
                    } else {
                        v.showpass.setText("SHOW PASS");
                        v.jpass.setEchoChar('*');
                    }
                }
            }
        });

        v.dn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uuser = v.juser.getText();
                String ppass = String.valueOf(v.jpass.getPassword());
                StringBuilder sb = new StringBuilder();
                if (uuser.equals("")) {
                    sb.append("Bạn Chưa Nhận UserName !! \n");
                }
                if (ppass.equals("")) {
                    sb.append("Bạn chưa nhập PassWord !! \n");
                }
                if (sb.length() > 0) {
                    JOptionPane.showMessageDialog(null, sb.toString(), "LỖI !!!", JOptionPane.YES_OPTION);
                }
               else {
                    try {
                        sql.sql();
                        String sql = "SELECT * FROM taotk\n" +
                                "WHERE username=? AND password =? ";
                        PreparedStatement ps = s.conn.prepareStatement(sql);
                        ps.setString(1, uuser);
                        ps.setString(2, ppass);
                        ResultSet rs = ps.executeQuery();
                        if(rs.next()) {
                            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                            new thongtin();
                            v.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Đăng nhập thất bại !\n"+"Sai UserName hoặc PassWord !!");
                        }
                        s.conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        v.taotk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new taotaikhoan();
                v.dispose();
            }
        });

        Timer timer = new Timer(450, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
                v.dangn.setVisible(visible);
                visible = !visible;
            }
        });
        timer.start();

        Timer timer2 = new Timer(500, new ActionListener() {
            boolean flag = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thay đổi màu của JLabel
                if (flag) {
                    v.dn.setForeground(Color.BLACK);
                    v.b2.setBackground(Color.PINK);
                } else {
                    v.dn.setForeground(Color.red);
                    v.b2.setBackground(Color.cyan);
                }
                flag = !flag;
            }
        });
        timer2.start();

    }
    public static void main(String args[]) {
        new login();
    }
}
