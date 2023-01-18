package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;

public class viewthongtinhocsinh extends JFrame {
    public static PopupMenu menu;
    public static DefaultTableModel model;
    public static Label tths;
    public static JTable jTable;
    public static JButton save, timkiem, moi, sua, all, xoa,xoaall, nha;
    public static JPanel j2;
    public static JLabel mahs, hoten, dantoc, gioitinh, ngaysinh, noisinh, sdt, diemxet, lop, kc;
    public static JTextField nmahs, nhoten, ndantoc, ngioitinh, nnggaysinh, nnoisinh, nsdt, ndiemxet, nlop;

    public viewthongtinhocsinh() {
        Container con = this.getContentPane();

        JButton b1 = new JButton();
        con.add(b1, BorderLayout.NORTH);
        b1.setBackground(Color.LIGHT_GRAY);

        JButton b2 = new JButton();
        con.add(b2, BorderLayout.SOUTH);
        b2.setBackground(Color.PINK);


        tths = new Label("THÔNG TIN HỌC SINH", Label. CENTER);
        tths.setForeground(Color.red);
        tths.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        b1.add(tths);

        menu = new PopupMenu();


        JPanel j1 = new JPanel();
        j1.setLayout(new GridLayout(9,1));
        j1.setBackground(Color.WHITE);

        mahs = new JLabel("Mã Hồ Sơ : ", JLabel.CENTER);
        nmahs = new JTextField();
        nmahs.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 12));
        j1.add(mahs);
        j1.add(nmahs);

        hoten = new JLabel("Họ Tên : ", JLabel.CENTER);
        nhoten = new JTextField();
        j1.add(hoten);
        j1.add(nhoten);

        dantoc = new JLabel("Dân Tộc : ", JLabel.CENTER);
        ndantoc = new JTextField();
        j1.add(dantoc);
        j1.add(ndantoc);

        gioitinh = new JLabel("Giới Tính : ", JLabel.CENTER);
        ngioitinh = new JTextField();
        j1.add(gioitinh);
        j1.add(ngioitinh);

        ngaysinh = new JLabel("Ngày Sinh", JLabel.CENTER);
        nnggaysinh = new JTextField();
        j1.add(ngaysinh);
        j1.add(nnggaysinh);

        noisinh = new JLabel("Nơi Sinh", JLabel.CENTER);
        nnoisinh = new JTextField();
        j1.add(noisinh);
        j1.add(nnoisinh);

        sdt = new JLabel("SĐT : ", JLabel.CENTER);
        nsdt = new JTextField();
        j1.add(sdt);
        j1.add(nsdt);

        diemxet = new JLabel("Điểm Xét Tuyển : ", JLabel.CENTER);
        ndiemxet = new JTextField();
        ndiemxet.setFont(new java.awt.Font("Arial", Font.TYPE1_FONT | Font.BOLD, 15));
        j1.add(diemxet);
        j1.add(ndiemxet);

        lop = new JLabel("Tên Lớp : ", JLabel.CENTER);
        nlop = new JTextField();
        j1.add(lop);
        j1.add(nlop);
        con.add(j1, BorderLayout.CENTER);


        j2 = new JPanel();
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

        //---------------------------
        model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn("Mã HS");
        model.addColumn("Họ Tên");
        model.addColumn("Dân Tộc");
        model.addColumn("Giới Tính");
        model.addColumn("Ngày Sinh");
        model.addColumn("Nơi Sinh");
        model.addColumn("SĐT");
        model.addColumn("Điểm XT");
        model.addColumn("Tên Lớp");

        jTable = new JTable(model);
        jTable.setModel(model);
        jTable.setBackground(Color.DARK_GRAY);
        jTable.setForeground(Color.GREEN);

        TableColumnModel columnModel = jTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(110);

        JScrollPane js = new JScrollPane(jTable);
        LineBorder lfb = new LineBorder(Color.CYAN, 5);
        js.setBorder(lfb);
        js.setPreferredSize(new Dimension(950,180));


        JPanel jbn = new JPanel();
        Border bd = BorderFactory.createLineBorder(Color.BLACK,1);
        TitledBorder tlbd = BorderFactory.createTitledBorder(bd, " HỌC SINH ");
        jbn.setBorder(tlbd);
        jbn.setBackground(Color.PINK);
        js.add(jbn);

        b2.add(js);

        setTitle("Thông Tin HS");
        setSize(1000,600);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
