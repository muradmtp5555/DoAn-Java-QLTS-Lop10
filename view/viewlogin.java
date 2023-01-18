package view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;

public class viewlogin extends JFrame {
    public static JButton b1 ,b2 ,showpass;
    public static JLabel username, pass;
    public static JPasswordField jpass;
    public static Label dangn;
    public static JTextField juser;
    public static JButton taotk, dn;
    public viewlogin() {
        Container con = this.getContentPane();

        b1 = new JButton();
        con.add(b1, BorderLayout.NORTH);
        b1.setBackground(Color.lightGray);

        b2 = new JButton();
        con.add(b2, BorderLayout.CENTER);
        b2.setBackground(Color.CYAN);
        b2.setLayout(new GridLayout(1, 0));

        dangn = new Label(" LOGIN", Label.CENTER);
        dangn.setForeground(Color.RED);
        dangn.setFont(new java.awt.Font("Arial", Font.ITALIC | Font.BOLD, 15));
        b1.add(dangn);


        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 1));

        username = new JLabel(" UserName : ");
        juser = new JTextField(JTextField.CENTER);
        p.add(username);
        p.add(juser);
        username.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/user.png"))));

        pass = new JLabel(" PassWord : ");
        jpass = new JPasswordField();
        p.add(pass);
        p.add(jpass);
        pass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/pass.png"))));

        JPanel pn = new JPanel();

        showpass = new JButton("SHOW PASS");
        showpass.setForeground(Color.BLACK);
        showpass.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/show.png"))));
        Border line = BorderFactory.createLineBorder(Color.green, 4);
        showpass.setBorder(line);

        taotk = new JButton("TẠO TK");
        taotk.setForeground(Color.BLACK);
        taotk.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/taotk.png"))));
        Border line1 = BorderFactory.createLineBorder(Color.MAGENTA, 4);
        taotk.setBorder(line1);

        JPanel pn2 = new JPanel();

        dn = new JButton("LOGIN");
        dn.setLayout(new FlowLayout(FlowLayout.RIGHT));
        dn.setForeground(Color.RED);
        dn.setMnemonic(KeyEvent.VK_ENTER);
        dn.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(viewlogin.class.getResource("/img/login.png"))));
        Border line2 = BorderFactory.createLineBorder(Color.CYAN, 4);
        dn.setBorder(line2);


        pn.add(taotk);
        pn.add(showpass);
        pn2.add(dn);
        p.add(pn);
        p.add(pn2);
        con.add(p, BorderLayout.CENTER);

        setTitle("LOGIN");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
