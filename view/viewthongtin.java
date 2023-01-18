package view;

import javax.swing.*;
import java.awt.*;

public class viewthongtin extends JFrame {
    public static Label la;
    public static JButton j1, hs, tt, tdv;
    public viewthongtin() {
        j1 = new JButton();
        add(j1, BorderLayout.CENTER);
        j1.setBackground(Color.darkGray);

        JButton j2 = new JButton();
        add(j2, BorderLayout.NORTH);
        j2.setBackground(Color.PINK);

        la = new Label("QUẢN LÝ TUYỂN SINH LỚP 10 ", Label.CENTER);
        la.setForeground(Color.red);
        la.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        j2.add(la);


        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.LINE_AXIS));
        jp.setBackground(Color.darkGray);

        hs = new JButton("HỒ SƠ HỌC SINH");
        hs.setForeground(Color.white);
        hs.setBorderPainted(false);
        hs.setContentAreaFilled(false);
        jp.add(hs);
        hs.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/thongtin.png"))));

        tt = new JButton("HỌC BẠ");
        tt.setForeground(Color.green);
        tt.setBorderPainted(false);
        tt.setContentAreaFilled(false);
        jp.add(tt);
        tt.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/hocba.png"))));

        tdv = new JButton("ĐIỂM THI");
        tdv.setForeground(Color.CYAN);
        tdv.setBorderPainted(false);
        tdv.setContentAreaFilled(false);
        jp.add(tdv);
        tdv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/diemthi.png"))));

        j1.add(jp);

        setTitle("THÔNG TIN");
        setSize(400,200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
