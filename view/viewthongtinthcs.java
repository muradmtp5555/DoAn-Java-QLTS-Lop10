package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class viewthongtinthcs extends JFrame {

    public static JButton save, moi, all, timkiem, xuatdau, sua, xoa, xoaall, nha;
    public static  Label td;
    public static JLabel chitieuhocba, diemsan, mahs, hoten, truong, hkl6, hll6,
            dtbl6, hkl7, hll7, dtbl7, hkl8, hll8, dtbl8, hkl9, hll9, dtbl9, tdhb;
    public static JTextField nchitieuhocba, ndiemsan, nmahs, nhoten, ntruong, nhkl6,
            nhll6, ndtbl6, nhkl7, nhll7, ndtbl7, nhkl8, nhll8, ndtbl8, nhkl9, nhll9, ndtbl9, ntdhb;
    public static DefaultTableModel model;
    public static JTable jTable;

    public viewthongtinthcs() {
        Container con = this.getContentPane();

        JButton b1 = new JButton();
        con.add(b1, BorderLayout.NORTH);
        b1.setBackground(Color.LIGHT_GRAY);


        td = new Label("HỌC BẠ", Label.CENTER);
        td.setForeground(Color.RED);
        td.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        b1.add(td);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(6,1));

        chitieuhocba = new JLabel("Chỉ Tiêu HB : ", JLabel.CENTER);
        nchitieuhocba = new JTextField();
        chitieuhocba.setForeground(Color.RED);
        nchitieuhocba.setForeground(Color.RED);
        nchitieuhocba.setHorizontalAlignment(JTextField.CENTER);
        jp1.add(chitieuhocba);
        jp1.add(nchitieuhocba);

        diemsan = new JLabel("Điểm Sàn : ", JLabel.CENTER);
        ndiemsan = new JTextField();
        diemsan.setForeground(Color.RED);
        ndiemsan.setForeground(Color.RED);
        ndiemsan.setHorizontalAlignment(JTextField.CENTER);
        jp1.add(diemsan);
        jp1.add(ndiemsan);


        mahs = new JLabel("Mã Hồ Sơ : ", JLabel.CENTER);
        nmahs = new JTextField();
        nmahs.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 12));
        jp1.add(mahs);
        jp1.add(nmahs);

        hoten = new JLabel("Họ Tên : ", JLabel.CENTER);
        nhoten = new JTextField();
        jp1.add(hoten);
        jp1.add(nhoten);

        truong = new JLabel("Học Sinh Trường : ", JLabel.CENTER);
        ntruong = new JTextField();
        jp1.add(truong);
        jp1.add(ntruong);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(12, 1));

        hkl6 = new JLabel("HK Lớp 6 : ", JLabel.CENTER);
        nhkl6 = new JTextField();
        jp2.add(hkl6);
        jp2.add(nhkl6);

        hll6 = new JLabel("HL Lớp 6 : ", JLabel.CENTER);
        nhll6 = new JTextField();
        jp2.add(hll6);
        jp2.add(nhll6);

        dtbl6 = new JLabel("Điểm TB Lớp 6 : ", JLabel.CENTER);
        dtbl6.setForeground(Color.RED);
        ndtbl6 = new JTextField();
        ndtbl6.setHorizontalAlignment(JTextField.CENTER);
        jp2.add(dtbl6);
        jp2.add(ndtbl6);

        hkl7 = new JLabel("HK Lớp 7 : ", JLabel.CENTER);
        nhkl7 = new JTextField();
        jp2.add(hkl7);
        jp2.add(nhkl7);

        hll7 = new JLabel("HL Lớp 7 : ", JLabel.CENTER);
        nhll7 = new JTextField();
        jp2.add(hll7);
        jp2.add(nhll7);

        dtbl7 = new JLabel("Điểm TB Lớp 7 : ", JLabel.CENTER);
        dtbl7.setForeground(Color.RED);
        ndtbl7 = new JTextField();
        ndtbl7.setHorizontalAlignment(JTextField.CENTER);
        jp2.add(dtbl7);
        jp2.add(ndtbl7);

        hkl8 = new JLabel("HK Lớp 8 : ", JLabel.CENTER);
        nhkl8 = new JTextField();
        jp2.add(hkl8);
        jp2.add(nhkl8);

        hll8 = new JLabel("HL Lớp 8 : ", JLabel.CENTER);
        nhll8 = new JTextField();
        jp2.add(hll8);
        jp2.add(nhll8);

        dtbl8 = new JLabel("Điểm TB Lớp 8 : ", JLabel.CENTER);
        dtbl8.setForeground(Color.RED);
        ndtbl8 = new JTextField();
        ndtbl8.setHorizontalAlignment(JTextField.CENTER);
        jp2.add(dtbl8);
        jp2.add(ndtbl8);

        hkl9 = new JLabel("HK Lớp 9 : ", JLabel.CENTER);
        nhkl9 = new JTextField();
        jp2.add(hkl9);
        jp2.add(nhkl9);

        hll9 = new JLabel("HL Lớp 9 : ", JLabel.CENTER);
        nhll9 = new JTextField();
        jp2.add(hll9);
        jp2.add(nhll9);

        dtbl9 = new JLabel("Điểm TB Lớp 9 : ", JLabel.CENTER);
        dtbl9.setForeground(Color.RED);
        ndtbl9 = new JTextField();
        ndtbl9.setHorizontalAlignment(JTextField.CENTER);
        jp2.add(dtbl9);
        jp2.add(ndtbl9);

        tdhb = new JLabel("Tổng Điểm Học Bạ : ", JLabel.CENTER);
        ntdhb = new JTextField();
        ntdhb.setEditable(false);
        ntdhb.setFont(new java.awt.Font("Arial", Font.TYPE1_FONT | Font.BOLD, 15));
        jp1.add(tdhb);
        jp1.add(ntdhb);

        con.add(jp1, BorderLayout.LINE_START);
        con.add(jp2);

        model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Mã HS");
        model.addColumn("Họ Tên");
        model.addColumn("Trường");
        model.addColumn("HK lớp 6");
        model.addColumn("HL lớp 6");
        model.addColumn("Điểm TB lớp 6");
        model.addColumn("HK lớp 7");
        model.addColumn("HL lớp 7");
        model.addColumn("Điểm TB lớp 7");
        model.addColumn("HK lớp 8");
        model.addColumn("HL lớp 8");
        model.addColumn("Điểm TB lớp 8");
        model.addColumn("HK lớp 9");
        model.addColumn("HL lớp 9");
        model.addColumn("Điểm TB lớp 9");
        model.addColumn("TĐ Học Bạ");

        jTable = new JTable(model);
        jTable.setModel(model);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setForeground(Color.GREEN);

        TableColumnModel columnModel = jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(110);

        JScrollPane js = new JScrollPane(jTable);
        js.setBorder(new LineBorder(Color.red,3));
        js.setPreferredSize(new Dimension(950,150));
        con.add(js, BorderLayout.SOUTH);

        JPanel j2 = new JPanel();
        j2.setLayout(new BoxLayout(j2, BoxLayout.Y_AXIS));
        j2.setBackground(Color.darkGray);

        save = new JButton("SAVE");
        save.setForeground(Color.YELLOW);
        save.setBorderPainted(false);
        save.setContentAreaFilled(false);
        j2.add(save);
        save.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/save.png"))));

        timkiem = new JButton("TÌM KIẾM");
        timkiem.setForeground(Color.cyan);
        timkiem.setBorderPainted(false);
        timkiem.setContentAreaFilled(false);
        j2.add(timkiem);
        timkiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/timkiem.png"))));

        moi = new JButton("LÀM MỚI");
        moi.setForeground(Color.green);
        moi.setBorderPainted(false);
        moi.setContentAreaFilled(false);
        j2.add(moi);
        moi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/lammoi.png"))));


        sua = new JButton("SỬA");
        sua.setForeground(Color.YELLOW);
        sua.setBorderPainted(false);
        sua.setContentAreaFilled(false);
        j2.add(sua);
        sua.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/sua.png"))));

        all = new JButton("SHOW TẤT CẢ");
        all.setForeground(Color.GREEN);
        all.setBorderPainted(false);
        all.setContentAreaFilled(false);
        j2.add(all);
        all.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/showall.png"))));


        xuatdau = new JButton("XUẤT DS ĐẬU");
        xuatdau.setForeground(Color.cyan);
        xuatdau.setBorderPainted(false);
        xuatdau.setContentAreaFilled(false);
        xuatdau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/xuatdau.png"))));
        j2.add(xuatdau);


        xoa = new JButton("XÓA HỌC SINH");
        xoa.setForeground(Color.WHITE);
        xoa.setBorderPainted(false);
        xoa.setContentAreaFilled(false);
        j2.add(xoa);
        xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/xoahs.png"))));


        xoaall = new JButton("XÓA TẤT CẢ HỌC SINH");
        xoaall.setForeground(Color.RED);
        xoaall.setBorderPainted(false);
        xoaall.setContentAreaFilled(false);
        j2.add(xoaall);
        xoaall.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/xoall.png"))));


        nha = new JButton("NHÀ");
        nha.setForeground(Color.CYAN);
        nha.setBorderPainted(false);
        nha.setContentAreaFilled(false);
        nha.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/nha.png"))));
        j2.add(nha);

        con.add(j2, BorderLayout.EAST);

        setTitle("Học Bạ");
        setSize(1500,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
