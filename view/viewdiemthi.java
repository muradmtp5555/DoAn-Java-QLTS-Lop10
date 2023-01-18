package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class viewdiemthi extends JFrame {
    public static JScrollPane js;
    public static Label td;
    public static JLabel chitieudiem, diemchuan, mahs, hoten, diemthinv, diemthitoan, diemthita, diemvung, dxt;
    public static JTextField nchitieudiem, ndiemchuan, nmahs, nhoten, ndiemthinv, ndiemthitoan, ndiemthita, ndiemvung, ndxt;
    public static DefaultTableModel model;
    public static JTable jTable;
    public static JButton save, timkiem, moi, sua, xuatdau, xoa, xoaall, all, nha;
    public viewdiemthi() {

        Container con = this.getContentPane();
        JButton b1 = new JButton();
        con.add(b1, BorderLayout.NORTH);
        b1.setBackground(Color.LIGHT_GRAY);


        td = new Label("ĐIỂM THI", Label.CENTER);
        td.setForeground(Color.RED);
        td.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        b1.add(td);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(9,1));

        chitieudiem = new JLabel("Chỉ Tiêu : ", JLabel.CENTER);
        nchitieudiem = new JTextField();
        chitieudiem.setForeground(Color.RED);
        nchitieudiem.setForeground(Color.RED);
        nchitieudiem.setHorizontalAlignment(JTextField.CENTER);
        jp1.add(chitieudiem);
        jp1.add(nchitieudiem);

        diemchuan = new JLabel("Điểm Chuẩn : ", JLabel.CENTER);
        ndiemchuan = new JTextField();
        diemchuan.setForeground(Color.RED);
        ndiemchuan.setForeground(Color.RED);
        ndiemchuan.setHorizontalAlignment(JTextField.CENTER);
        jp1.add(diemchuan);
        jp1.add(ndiemchuan);


        mahs = new JLabel("Mã Hồ Sơ : ", JLabel.CENTER);
        nmahs = new JTextField();
        nmahs.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 12));
        jp1.add(mahs);
        jp1.add(nmahs);

        hoten = new JLabel("Họ Tên : ", JLabel.CENTER);
        nhoten = new JTextField();
        jp1.add(hoten);
        jp1.add(nhoten);

        diemthinv = new JLabel("Điểm Thi Ngữ Văn : ", JLabel.CENTER);
        ndiemthinv = new JTextField();
        jp1.add(diemthinv);
        jp1.add(ndiemthinv);

        diemthitoan = new JLabel("Điểm Thi Toán : ", JLabel.CENTER);
        ndiemthitoan = new JTextField();
        jp1.add(diemthitoan);
        jp1.add(ndiemthitoan);

        diemthita = new JLabel("Điểm Thi Tiếng Anh : ", JLabel.CENTER);
        ndiemthita = new JTextField();
        jp1.add(diemthita);
        jp1.add(ndiemthita);

        diemvung = new JLabel("Điểm Vùng (Nếu Không Có Nhập 0 ) : ", JLabel.CENTER);
        ndiemvung = new JTextField();
        jp1.add(diemvung);
        jp1.add(ndiemvung);

        dxt = new JLabel("Điểm Xét Tuyển : ", JLabel.CENTER);
        ndxt = new JTextField();
        ndxt.setEditable(false);
        ndxt.setFont(new java.awt.Font("Arial", Font.TYPE1_FONT | Font.BOLD, 15));
        jp1.add(dxt);
        jp1.add(ndxt);

        con.add(jp1);

        model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Mã HS");
        model.addColumn("Họ Tên");
        model.addColumn("Điểm Thi NV");
        model.addColumn("Điểm Thi Toán");
        model.addColumn("Điểm Thi Tiếng Anh");
        model.addColumn("Điểm Vùng");
        model.addColumn("Điểm Xét Tuyển");
        jTable = new JTable(model);
        jTable.setModel(model);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setForeground(Color.CYAN);

        TableColumnModel columnModel = jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(110);

        js = new JScrollPane(jTable);
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



        setTitle("Điểm Thi");
        setSize(800,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
