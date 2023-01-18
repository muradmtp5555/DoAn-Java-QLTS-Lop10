package xulysukien;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import ketnoisql.sql;
import view.viewthongtinhocsinh;

public class thongtinhocsinh extends JFrame {

    public thongtinhocsinh() {
        sql s = new sql();
        viewthongtinhocsinh vtths = new viewthongtinhocsinh();

        vtths.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mhs = vtths.nmahs.getText();
                String ht = vtths.nhoten.getText();
                String dt = vtths.ndantoc.getText();
                String gt = vtths.ngioitinh.getText();
                String ngays = vtths.nnggaysinh.getText();
                String ns = vtths.nnoisinh.getText();
                int sd = Integer.parseInt(vtths.nsdt.getText());
                Double diem = Double.parseDouble(vtths.ndiemxet.getText());
                String lopp = vtths.nlop.getText();

                Vector hang = new Vector();
                hang.add(mhs);
                hang.add(ht);
                hang.add(dt);
                hang.add(gt);
                hang.add(ngays);
                hang.add(ns);
                hang.add(sd);
                hang.add(diem);
                hang.add(lopp);

                vtths.model.addRow(hang);

                StringBuilder sb = new StringBuilder();
                sb.append("ĐÃ THÊM VÀO BẢNG !!");
                JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                //-----------------------------------------------------------------------------------------------------------------------------------------

                try {
                    sql.sql();
                    // lặp qua từng hàng trong bảng

                    String sqll = "INSERT INTO tths (MaHS, HoTen, DanToc, GioiTinh, NgaySinh, NoiSinh, SDT, DiemXT, TenLop) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = s.conn.prepareStatement(sqll);

                    stmt.setString(1, mhs);
                    stmt.setString(2, ht);
                    stmt.setString(3, dt);
                    stmt.setString(4, gt);
                    stmt.setString(5, ngays);
                    stmt.setString(6, ns);
                    stmt.setInt(7, sd);
                    stmt.setDouble(8, diem);
                    stmt.setString(9, lopp);
                    stmt.executeUpdate();
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        //-------------------------------------------------------------------------------------------------------------
        //---------------------------------------------------------------------------------------------------------------

        vtths.timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ma = vtths.nmahs.getText();

                try {
                    sql.sql();

                    String sql = "SELECT * FROM tths WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1,ma);
                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vtths.jTable.getModel();
                    while (rs.next()) {
                         md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                         rs.getString(3), rs.getString(4),
                         rs.getString(5), rs.getString(6),
                         rs.getString(7), rs.getString(8), rs.getString(9)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vtths.sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sql.sql();

                    String sql = "UPDATE tths SET MaHS = ?, HoTen = ?, DanToc = ?, GioiTinh = ?, NgaySinh = ?, NoiSinh = ?, SDT = ?, DiemXT = ?, TenLop = ? WHERE MaHS = ?";
                    PreparedStatement pstmt = s.conn.prepareStatement(sql);

                    String mhs = vtths.nmahs.getText();
                    String ht = vtths.nhoten.getText();
                    String dt = vtths.ndantoc.getText();
                    String gt = vtths.ngioitinh.getText();
                    String ngays = vtths.nnggaysinh.getText();
                    String ns = vtths.nnoisinh.getText();
                    long sd = Integer.parseInt(vtths.nsdt.getText());
                    Double diem = Double.parseDouble(vtths.ndiemxet.getText());
                    String lopp = vtths.nlop.getText();


                    pstmt.setString(1, mhs);
                    pstmt.setString(2, ht);
                    pstmt.setString(3, dt);
                    pstmt.setString(4, gt);
                    pstmt.setString(5, ngays);
                    pstmt.setString(6, ns);
                    pstmt.setLong(7, sd);
                    pstmt.setDouble(8, diem);
                    pstmt.setString(9, lopp);
                    pstmt.setString(10, mhs);
                    pstmt.executeUpdate();

                    vtths.model.setRowCount(0);
                    s.conn.close();
                    StringBuilder sb = new StringBuilder();
                    sb.append("SỬA THÀNH CÔNG !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vtths.moi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vtths.nmahs.setText("");
                vtths.nhoten.setText("");
                vtths.ndantoc.setText("");
                vtths.ngioitinh.setText("");
                vtths.nnggaysinh.setText("");
                vtths.nnoisinh.setText("");
                vtths.nsdt.setText("");
                vtths.ndiemxet.setText("");
                vtths.nlop.setText("");
                vtths.model.setRowCount(0);
            }
        });

        vtths.all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sql.sql();

                    String sql = "SELECT * FROM tths";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vtths.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        vtths.xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ma = vtths.nmahs.getText();
                try {
                    sql.sql();

                    String sql = "DELETE FROM tths WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1, ma);
                    prst.executeUpdate();
                    s.conn.close();
                    vtths.jTable.repaint();

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA SINH VIÊN "+ma+ " !!! \n");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vtths.xoaall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sql.sql();

                    String sql = "DELETE FROM tths";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.executeUpdate();
                    s.conn.close();
                    vtths.jTable.repaint();

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA TẤT CẢ SINH VIÊN !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        vtths.nha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new thongtin();
                vtths.dispose();
            }
        });

        vtths.jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy vị trí hàng được click
                int row = vtths.jTable.rowAtPoint(e.getPoint());
                // Lấy dữ liệu từ hàng đó
                String data = (String) vtths.jTable.getModel().getValueAt(row, 0);
                String data1 = (String) vtths.jTable.getModel().getValueAt(row, 1);
                String data2 = (String) vtths.jTable.getModel().getValueAt(row, 2);
                String data3 = (String) vtths.jTable.getModel().getValueAt(row, 3);
                String data4 = (String) vtths.jTable.getModel().getValueAt(row, 4);
                String data5 = (String) vtths.jTable.getModel().getValueAt(row, 5);
                String data6 = (String) vtths.jTable.getModel().getValueAt(row, 6);
                String data7 = (String) vtths.jTable.getModel().getValueAt(row, 7);
                String data8 = (String) vtths.jTable.getModel().getValueAt(row, 8);

                // Hiển thị dữ liệu lên JTextField
                vtths.nmahs.setText(data);
                vtths.nhoten.setText(data1);
                vtths.ndantoc.setText(data2);
                vtths.ngioitinh.setText(data3);
                vtths.nnggaysinh.setText(data4);
                vtths.nnoisinh.setText(data5);
                vtths.nsdt.setText(data6);
                vtths.ndiemxet.setText(data7);
                vtths.nlop.setText(data8);

            }
        });

        Timer timer = new Timer(450, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
                vtths.tths.setVisible(visible);
                visible = !visible;
            }
        });
        timer.start();

    }
    public static void main(String args[]) {
        new thongtinhocsinh();
    }
}
