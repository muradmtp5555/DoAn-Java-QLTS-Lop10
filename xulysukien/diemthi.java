package xulysukien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import view.viewdiemthi;
import ketnoisql.sql;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class diemthi extends JFrame {
    public diemthi() {
        viewdiemthi vdt = new viewdiemthi();
        sql s = new sql();

        vdt.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahs = vdt.nmahs.getText();
                String ht = vdt.nhoten.getText();
                Double dnv = Double.valueOf(vdt.ndiemthinv.getText());
                Double dt = Double.valueOf(vdt.ndiemthitoan.getText());
                Double dta = Double.valueOf(vdt.ndiemthita.getText());
                Double dv = Double.valueOf(vdt.ndiemvung.getText());

                Double tdxt = (dt*2 + dnv*2 + dta + dv);
                vdt.ndxt.setText(String.valueOf(tdxt));
                Double dxt = Double.valueOf(vdt.ndxt.getText());

                Vector hang = new Vector();
                hang.add(mahs);
                hang.add(ht);
                hang.add(dnv);
                hang.add(dt);
                hang.add(dta);
                hang.add(dv);
                hang.add(dxt);


                vdt.model.addRow(hang);
                vdt.model.fireTableDataChanged();

                StringBuilder sb = new StringBuilder();
                sb.append("ĐÃ THÊM VÀO BẢNG !!");
                JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                //=============================================================================================================

                try {
                    sql.sql();
                    // lặp qua từng hàng trong bảng

                    String sqll = "INSERT INTO diemthi (MaHS, HoTen, DiemNV, DiemTOAN, DiemTA, DiemVung, DiemXT) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = s.conn.prepareStatement(sqll);

                    stmt.setString(1, mahs);
                    stmt.setString(2, ht);
                    stmt.setDouble(3, dnv);
                    stmt.setDouble(4, dt);
                    stmt.setDouble(5, dta);
                    stmt.setDouble(6, dv);
                    stmt.setDouble(7, dxt);

                    stmt.executeUpdate();
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdt.model.addColumn(0);
                String ma = vdt.nmahs.getText();

                try {
                    sql.sql();

                    String sql = "SELECT * FROM diemthi WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1, ma);

                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vdt.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.moi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdt.nmahs.setText("");
                vdt.nhoten.setText("");
                vdt.ndiemthinv.setText("");
                vdt.ndiemthitoan.setText("");
                vdt.ndiemthita.setText("");
                vdt.ndiemvung.setText("");
                vdt.ndxt.setText("");

                vdt.model.setRowCount(0);
            }
        });

        vdt.sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sql.sql();

                    String sql = "UPDATE diemthi SET MaHS = ?, HoTen = ?, DiemNV = ?, DiemTOAN = ?, DiemTA = ?, DiemVung = ?, DiemXT = ? WHERE MaHS = ?";
                    PreparedStatement pstmt = s.conn.prepareStatement(sql);

                    String mahs = vdt.nmahs.getText();
                    String ht = vdt.nhoten.getText();
                    Double dnv = Double.valueOf(vdt.ndiemthinv.getText());
                    Double dt = Double.valueOf(vdt.ndiemthitoan.getText());
                    Double dta = Double.valueOf(vdt.ndiemthita.getText());
                    Double dv = Double.valueOf(vdt.ndiemvung.getText());

                    Double tdxt = (dt*2 + dnv*2 + dta + dv);
                    vdt.ndxt.setText(String.valueOf(tdxt));
                    Double dxt = Double.valueOf(vdt.ndxt.getText());

                    pstmt.setString(1, mahs);
                    pstmt.setString(2, ht);
                    pstmt.setDouble(3, dnv);
                    pstmt.setDouble(4, dt);
                    pstmt.setDouble(5, dta);
                    pstmt.setDouble(6, dv);
                    pstmt.setDouble(7, dxt);
                    pstmt.setString(8, mahs);
                    pstmt.executeUpdate();
                    vdt.model.setRowCount(0);
                    s.conn.close();

                    StringBuilder sb = new StringBuilder();
                    sb.append("SỬA THÀNH CÔNG !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdt.model.setRowCount(0);
                try {
                    sql.sql();

                    String sql = "SELECT * FROM diemthi";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vdt.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.xuatdau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vdt.model.setRowCount(0);
                int ct = Integer.parseInt(vdt.nchitieudiem.getText());
                String diemchuan = vdt.ndiemchuan.getText();

                try {
                    sql.sql();
                    String sql = "SELECT TOP(?) * FROM diemthi WHERE DiemXT > ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setInt(1, ct);
                    prst.setString(2, diemchuan);

                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vdt.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ma = vdt.nmahs.getText();
                try {
                    sql.sql();

                    String sql = "DELETE FROM diemthi WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1, ma);
                    prst.executeUpdate();
                    s.conn.close();
                    vdt.jTable.repaint();

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA SINH VIÊN "+ma+ " !!! \n");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.xoaall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sql.sql();

                    String sql = "DELETE FROM diemthi";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.executeUpdate();
                    s.conn.close();
                    vdt.jTable.repaint();

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA TẤT CẢ SINH VIÊN !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vdt.jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy vị trí hàng được click
                int row = vdt.jTable.rowAtPoint(e.getPoint());
                // Lấy dữ liệu từ hàng đó
                String data = (String) vdt.jTable.getModel().getValueAt(row, 0);
                String data1 = (String) vdt.jTable.getModel().getValueAt(row, 1);
                String data2 = (String) vdt.jTable.getModel().getValueAt(row, 2);
                String data3 = (String) vdt.jTable.getModel().getValueAt(row, 3);
                String data4 = (String) vdt.jTable.getModel().getValueAt(row, 4);
                String data5 = (String) vdt.jTable.getModel().getValueAt(row, 5);
                String data6 = (String) vdt.jTable.getModel().getValueAt(row, 6);

                // Hiển thị dữ liệu lên JTextField
                vdt.nmahs.setText(data);
                vdt.nhoten.setText(data1);
                vdt.ndiemthinv.setText(data2);
                vdt.ndiemthitoan.setText(data3);
                vdt.ndiemthita.setText(data4);
                vdt.ndiemvung.setText(data5);
                vdt.ndxt.setText(data6);

            }
        });

        vdt.nha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new thongtin();
                vdt.dispose();
            }
        });
        Timer timer = new Timer(450, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
            vdt.td.setVisible(visible);
            visible = !visible;
            }
        });
        timer.start();

        Timer timer2 = new Timer(1000, new ActionListener() {
            boolean flag = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thay đổi màu của JLabel
                if (flag) {
                    vdt.chitieudiem.setForeground(Color.GREEN);
                    vdt.diemchuan.setForeground(Color.GREEN);
                } else {
                    vdt.chitieudiem.setForeground(Color.red);
                    vdt.diemchuan.setForeground(Color.red);
                }
                flag = !flag;
            }
        });
        timer2.start();
    }

    public static void main(String args[]) {
        new diemthi();
    }
}
