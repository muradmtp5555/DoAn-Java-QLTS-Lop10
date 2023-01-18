package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class viewtaotk extends JFrame {
        public static JButton b1 ,b2, quaylaidn, taotk;
        public static JLabel username, pass, confirmpassword;
        public static JPasswordField jpass, jconfirmpass;
        public static Label taotaikhoan;
        public static JTextField juser;
        public static JButton dn;
        public viewtaotk() {
            Container con = this.getContentPane();

            b1 = new JButton();
            con.add(b1, BorderLayout.NORTH);
            b1.setBackground(Color.lightGray);

            b2 = new JButton();
            con.add(b2, BorderLayout.CENTER);
            b2.setBackground(Color.CYAN);
            b2.setLayout(new GridLayout(1, 0));

            taotaikhoan = new Label(" TẠO TÀI KHOẢN", Label.CENTER);
            taotaikhoan.setForeground(Color.RED);
            taotaikhoan.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
            b1.add(taotaikhoan);


            JPanel p = new JPanel();
            p.setLayout(new GridLayout(4, 1));

            username = new JLabel(" UserName : ");
            juser = new JTextField(JTextField.CENTER);
            p.add(username);
            p.add(juser);
            username.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.viewlogin.class.getResource("/img/user.png"))));

            pass = new JLabel(" PassWord : ");
            jpass = new JPasswordField();
            p.add(pass);
            p.add(jpass);
            pass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.viewlogin.class.getResource("/img/pass.png"))));

            confirmpassword = new JLabel(" Confirm Password : ");
            jconfirmpass = new JPasswordField();
            p.add(confirmpassword);
            p.add(jconfirmpass);
            confirmpassword.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.viewlogin.class.getResource("/img/confirm.png"))));

            JPanel pn = new JPanel();

            quaylaidn = new JButton("QUAY LẠI ĐĂNG NHẬP");
            quaylaidn.setForeground(Color.BLACK);
            quaylaidn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.viewlogin.class.getResource("/img/ql.png"))));
            Border line = BorderFactory.createLineBorder(Color.green, 4);
            quaylaidn.setBorder(line);

            JPanel pn2 = new JPanel();

            dn = new JButton("TẠO TÀI KHOẢN");
            dn.setLayout(new FlowLayout(FlowLayout.RIGHT));
            dn.setLocation(450, 250);
            dn.setForeground(Color.RED);
            dn.setMnemonic(KeyEvent.VK_ENTER);
            dn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(view.viewlogin.class.getResource("/img/tick.png"))));
            Border line2 = BorderFactory.createLineBorder(Color.CYAN, 4);
            dn.setBorder(line2);


            pn.add(quaylaidn);
            pn2.add(dn);
            p.add(pn);
            p.add(pn2);
            con.add(p, BorderLayout.CENTER);

            setTitle("TẠO TÀI KHOẢN");
            setSize(500, 300);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
}
