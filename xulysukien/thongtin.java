package xulysukien;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.viewthongtin;

public class thongtin extends JFrame {
    public thongtin() {

        viewthongtin vtt = new viewthongtin();

        vtt.hs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new thongtinhocsinh();
                vtt.dispose();
            }
        });


        vtt.tt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new thongtinthcs();
                vtt.dispose();
            }
        });

        vtt.tdv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new diemthi();
            }
        });
        Timer timer = new Timer(450, new ActionListener() {
            boolean visible = true;
            public void actionPerformed(ActionEvent e) {
            vtt.la.setVisible(visible);
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
                    vtt.hs.setForeground(Color.YELLOW);
                } else {
                    vtt.hs.setForeground(Color.white);
                }
                flag = !flag;
            }
        });
        timer2.start();

    }
    public static void main(String args []) {
        new thongtin();
    }
}
