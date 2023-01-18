package xulysukien;

import javax.swing.*;

import ketnoisql.sql;
import view.viewtaotk;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class taotaikhoan extends JFrame {
    public taotaikhoan() {
        viewtaotk vttk = new viewtaotk();
        sql s = new sql();

        vttk.quaylaidn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new login();
               vttk.dispose();
            }
        });

        vttk.dn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uuser = vttk.juser.getText();
                String ppass = String.valueOf(vttk.jpass.getPassword());
                String confirmpass = String.valueOf(vttk.jconfirmpass.getPassword());

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
                if (!ppass.equals(confirmpass)) {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append("PassWord và Confirm PassWord Không Được Khác Nhau !!");
                    JOptionPane.showMessageDialog(null, sb1.toString(), "LỖI", JOptionPane.DEFAULT_OPTION);
                }
                else {
                    try {
                        sql.sql();
                        String sql = "INSERT INTO taotk (username, password, confirmpassword) VALUES (?, ?, ?)";

                        PreparedStatement stmt = s.conn.prepareStatement(sql);
                        stmt.setString(1, uuser);
                        stmt.setString(2, ppass);
                        stmt.setString(3, confirmpass);

                        stmt.executeUpdate();

                        StringBuilder sbb = new StringBuilder();
                        sbb.append("TẠO TÀI KHOẢN THÀNH CÔNG !!");
                        JOptionPane.showMessageDialog(null, sbb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                        s.conn.close();
                        new login();
                        vttk.dispose();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        Timer timer = new Timer(450, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
                viewtaotk.taotaikhoan.setVisible(visible);
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
                    viewtaotk.dn.setForeground(Color.BLACK);
                    viewtaotk.b2.setBackground(Color.PINK);
                } else {
                    vttk.dn.setForeground(Color.red);
                    vttk.b2.setBackground(Color.cyan);
                }
                flag = !flag;
            }
        });
        timer2.start();
    }
    public static void main(String args[]) {
        new taotaikhoan();
    }
}
