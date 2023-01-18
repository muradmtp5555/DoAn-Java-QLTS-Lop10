package xulysukien;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;
import view.viewthongtinthcs;
import ketnoisql.sql;

public class thongtinthcs extends JFrame {
    public Double tdiem;
    public thongtinthcs() {
        viewthongtinthcs vthcs = new viewthongtinthcs();
        sql s = new sql();


        vthcs.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mahs = vthcs.nmahs.getText();
                String ht = vthcs.nhoten.getText();
                String tr = vthcs.ntruong.getText();
                String hk6 = vthcs.nhkl6.getText();
                String hl6 = vthcs.nhll6.getText();
                Double tb6 = Double.parseDouble(vthcs.ndtbl6.getText());
                String hk7 = vthcs.nhkl7.getText();
                String hl7 = vthcs.nhll7.getText();
                Double tb7 = Double.parseDouble(vthcs.ndtbl7.getText());
                String hk8 = vthcs.nhkl8.getText();
                String hl8 = vthcs.nhll8.getText();
                Double tb8 = Double.parseDouble(vthcs.ndtbl8.getText());
                String hk9 = vthcs.nhkl9.getText();
                String hl9 = vthcs.nhll9.getText();
                Double tb9 = Double.parseDouble(vthcs.ndtbl9.getText());

                tdiem = (tb6+tb7+tb8+tb9);
                vthcs.ntdhb.setText(String.valueOf(tdiem));
                Double td = Double.parseDouble(vthcs.ntdhb.getText());

                Vector hang = new Vector();
                hang.add(mahs);
                hang.add(ht);
                hang.add(tr);
                hang.add(hk6);
                hang.add(hl6);
                hang.add(tb6);
                hang.add(hk7);
                hang.add(hl7);
                hang.add(tb7);
                hang.add(hk8);
                hang.add(hl8);
                hang.add(tb8);
                hang.add(hk9);
                hang.add(hl9);
                hang.add(tb9);
                hang.add(td);

                vthcs.model.addRow(hang);
                vthcs.model.fireTableDataChanged();

                StringBuilder sb = new StringBuilder();
                sb.append("ĐÃ THÊM VÀO BẢNG !!");
                JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                //=============================================================================================================

                try {
                    sql.sql();
                    // lặp qua từng hàng trong bảng

                    String sqll = "INSERT INTO ttthcs (MaHS, HoTen, Truong, HKL6, HLL6, DTBL6, HKL7, HLL7, DTBL7, HKL8, HLL8, DTBL8, HKL9, HLL9, DTBL9, DiemXT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement stmt = s.conn.prepareStatement(sqll);

                    stmt.setString(1, mahs);
                    stmt.setString(2, ht);
                    stmt.setString(3, tr);
                    stmt.setString(4, hk6);
                    stmt.setString(5, hl6);
                    stmt.setDouble(6, tb6);
                    stmt.setString(7, hk7);
                    stmt.setString(8, hl7);
                    stmt.setDouble(9, tb7);
                    stmt.setString(10, hk8);
                    stmt.setString(11, hl8);
                    stmt.setDouble(12, tb8);
                    stmt.setString(13, hk9);
                    stmt.setString(14, hl9);
                    stmt.setDouble(15, tb9);
                    stmt.setDouble(16, td);
                    stmt.executeUpdate();
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vthcs.moi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);

                vthcs.nmahs.setText("");
                vthcs.nhoten.setText("");
                vthcs.ntruong.setText("");
                vthcs.nhkl6.setText("");
                vthcs.nhll6.setText("");
                vthcs.ndtbl6.setText("");
                vthcs.nhkl7.setText("");
                vthcs.nhll7.setText("");
                vthcs.ndtbl7.setText("");
                vthcs.nhkl8.setText("");
                vthcs.nhll8.setText("");
                vthcs.ndtbl8.setText("");
                vthcs.nhkl9.setText("");
                vthcs.nhll9.setText("");
                vthcs.ndtbl9.setText("");
                vthcs.ntdhb.setText("");
                vthcs.model.setRowCount(0);
            }
        });



        vthcs.timkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                String ma = vthcs.nmahs.getText();

                try {
                    sql.sql();

                    String sql = "SELECT * FROM ttthcs WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1, ma);

                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vthcs.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getString(10), rs.getString(11),
                                rs.getString(12), rs.getString(13), rs.getString(14),
                                rs.getString(15), rs.getString(16)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vthcs.xuatdau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                int ct = Integer.parseInt(vthcs.nchitieuhocba.getText());
                String diemsan = vthcs.ndiemsan.getText();

                try {
                    sql.sql();
                    String sql = "SELECT TOP(?) * FROM ttthcs WHERE DiemXT > ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setInt(1, ct);
                    prst.setString(2, diemsan);

                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vthcs.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getString(10), rs.getString(11),
                                rs.getString(12), rs.getString(13), rs.getString(14),
                                rs.getString(15), rs.getString(16)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vthcs.all.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                try {
                    sql.sql();

                    String sql = "SELECT * FROM ttthcs";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    ResultSet rs = prst.executeQuery();

                    DefaultTableModel md = (DefaultTableModel) vthcs.jTable.getModel();
                    while (rs.next()) {
                        md.addRow(new Object[] {rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4),
                                rs.getString(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getString(9),
                                rs.getString(10), rs.getString(11),
                                rs.getString(12), rs.getString(13), rs.getString(14),
                                rs.getString(15), rs.getString(16)});

                    }
                    JTable jtb = new JTable();
                    jtb.setModel(md);
                    s.conn.close();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

        vthcs.sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                try {
                    sql.sql();

                    String sql = "UPDATE ttthcs SET MaHS = ?, HoTen = ?, Truong = ?, HKL6 = ?, HLL6 = ?, DTBL6 = ?, HKL7 = ?," +
                            " HLL7 = ?, DTBL7 = ?, HKL8 = ?, HLL8 = ?, DTBL8 = ?, HKL9 = ?, HLL9 = ?, DTBL9 = ?, DiemXT = ? WHERE MaHS = ?";
                    PreparedStatement pstmt = s.conn.prepareStatement(sql);

                    String mahs = vthcs.nmahs.getText();
                    String ht = vthcs.nhoten.getText();
                    String tr = vthcs.ntruong.getText();
                    String hk6 = vthcs.nhkl6.getText();
                    String hl6 = vthcs.nhll6.getText();
                    Double tb6 = Double.parseDouble(vthcs.ndtbl6.getText());
                    String hk7 = vthcs.nhkl7.getText();
                    String hl7 = vthcs.nhll7.getText();
                    Double tb7 = Double.parseDouble(vthcs.ndtbl7.getText());
                    String hk8 = vthcs.nhkl8.getText();
                    String hl8 = vthcs.nhll8.getText();
                    Double tb8 = Double.parseDouble(vthcs.ndtbl8.getText());
                    String hk9 = vthcs.nhkl9.getText();
                    String hl9 = vthcs.nhll9.getText();
                    Double tb9 = Double.parseDouble(vthcs.ndtbl9.getText());

                    tdiem = (tb6+tb7+tb8+tb9);
                    vthcs.ntdhb.setText(String.valueOf(tdiem));
                    Double td = Double.parseDouble(vthcs.ntdhb.getText());

                    pstmt.setString(1, mahs);
                    pstmt.setString(2, ht);
                    pstmt.setString(3, tr);
                    pstmt.setString(4, hk6);
                    pstmt.setString(5, hl6);
                    pstmt.setDouble(6, tb6);
                    pstmt.setString(7, hk7);
                    pstmt.setString(8, hl7);
                    pstmt.setDouble(9, tb7);
                    pstmt.setString(10, hk8);
                    pstmt.setString(11, hl8);
                    pstmt.setDouble(12, tb8);
                    pstmt.setString(13, hk9);
                    pstmt.setString(14, hl9);
                    pstmt.setDouble(15, tb9);
                    pstmt.setDouble(16, td);
                    pstmt.setString(17, mahs);
                    pstmt.executeUpdate();
                    vthcs.model.setRowCount(0);
                    s.conn.close();
                    StringBuilder sb = new StringBuilder();
                    sb.append("SỬA THÀNH CÔNG !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vthcs.nha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new thongtin();
                vthcs.dispose();
            }
        });

        vthcs.xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                String ma = vthcs.nmahs.getText();
                try {
                    sql.sql();

                    String sql = "DELETE FROM ttthcs WHERE MaHS = ?";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.setString(1, ma);
                    prst.executeUpdate();
                    s.conn.close();
                    vthcs.jTable.repaint();
                    vthcs.model.setRowCount(0);

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA SINH VIÊN "+ma+ " !!! \n");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        vthcs.xoaall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vthcs.model.setRowCount(0);
                try {
                    sql.sql();

                    String sql = "DELETE FROM ttthcs";
                    PreparedStatement prst = s.conn.prepareStatement(sql);
                    prst.executeUpdate();
                    s.conn.close();
                    vthcs.jTable.repaint();
                    vthcs.model.setRowCount(0);

                    StringBuilder sb = new StringBuilder();
                    sb.append("ĐÃ XÓA TẤT CẢ SINH VIÊN !!!");
                    JOptionPane.showMessageDialog(null, sb.toString(), "THÔNG BÁO", JOptionPane.DEFAULT_OPTION);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });



        vthcs.jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy vị trí hàng được click
                int row = vthcs.jTable.rowAtPoint(e.getPoint());
                // Lấy dữ liệu từ hàng đó
                String data = (String) vthcs.jTable.getModel().getValueAt(row, 0);
                String data1 = (String) vthcs.jTable.getModel().getValueAt(row, 1);
                String data2 = (String) vthcs.jTable.getModel().getValueAt(row, 2);
                String data3 = (String) vthcs.jTable.getModel().getValueAt(row, 3);
                String data4 = (String) vthcs.jTable.getModel().getValueAt(row, 4);
                String data5 = (String) vthcs.jTable.getModel().getValueAt(row, 5);
                String data6 = (String) vthcs.jTable.getModel().getValueAt(row, 6);
                String data7 = (String) vthcs.jTable.getModel().getValueAt(row, 7);
                String data8 = (String) vthcs.jTable.getModel().getValueAt(row, 8);
                String data9 = (String) vthcs.jTable.getModel().getValueAt(row, 9);
                String data10 = (String) vthcs.jTable.getModel().getValueAt(row, 10);
                String data11 = (String) vthcs.jTable.getModel().getValueAt(row, 11);
                String data12 = (String) vthcs.jTable.getModel().getValueAt(row, 12);
                String data13 = (String) vthcs.jTable.getModel().getValueAt(row, 13);
                String data14 = (String) vthcs.jTable.getModel().getValueAt(row, 14);
                String data15 = (String) vthcs.jTable.getModel().getValueAt(row, 15);

                // Hiển thị dữ liệu lên JTextField
                vthcs.nmahs.setText(data);
                vthcs.nhoten.setText(data1);
                vthcs.ntruong.setText(data2);
                vthcs.nhkl6.setText(data3);
                vthcs.nhll6.setText(data4);
                vthcs.ndtbl6.setText(data5);
                vthcs.nhkl7.setText(data6);
                vthcs.nhll7.setText(data7);
                vthcs.ndtbl7.setText(data8);
                vthcs.nhkl8.setText(data9);
                vthcs.nhll8.setText(data10);
                vthcs.ndtbl8.setText(data11);
                vthcs.nhkl9.setText(data12);
                vthcs.nhll9.setText(data13);
                vthcs.ndtbl9.setText(data14);
                vthcs.ntdhb.setText(data15);

            }
        });
        Timer timer1 = new Timer(500, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
            vthcs.td.setVisible(visible);
            visible = !visible;
            }
        });
        timer1.start();

        Timer timer2 = new Timer(1000, new ActionListener() {
            boolean flag = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thay đổi màu của JLabel
                if (flag) {
                    vthcs.chitieuhocba.setForeground(Color.GREEN);
                    vthcs.diemsan.setForeground(Color.GREEN);
                } else {
                    vthcs.chitieuhocba.setForeground(Color.red);
                    vthcs.diemsan.setForeground(Color.red);
                }
                flag = !flag;
            }
        });
        timer2.start();
    }

    public static void main(String args[]) {
        new thongtinthcs();
    }
}
