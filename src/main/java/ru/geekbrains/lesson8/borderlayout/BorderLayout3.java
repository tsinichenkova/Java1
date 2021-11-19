package ru.geekbrains.lesson8.borderlayout;

import javax.swing.*;
import java.awt.*;

public class BorderLayout3 {

    static public class MyWindow extends JFrame {
        public MyWindow() {
            setBounds(500, 500, 400, 300);
            setTitle("FlowLayoutDemo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JButton[] jbs = new JButton[10];
            setLayout(new FlowLayout());
            for (int i = 0; i < jbs.length; i++) {
                jbs[i] = new JButton("#" + i);
                jbs[i].setPreferredSize(new Dimension(100, 30));
                add(jbs[i]);
            }
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }

}