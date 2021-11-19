package ru.geekbrains.lesson8.borderlayout;

import javax.swing.*;
import java.awt.*;

public class BorderLayout4 {

    static public class MyWindow extends JFrame {

        public MyWindow() {
            setBounds(500,500,400,300);
            setTitle("GridLayoutDemo");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            createButtons();
            setVisible(true);
        }

        private void createButtons() {
            JButton[] jbs = new JButton[10];
            setLayout(new GridLayout(4, 3));
            for (int i = 0; i < jbs.length; i++) {
                jbs[i] = new JButton("#" + i);
                add(jbs[i]);
            }
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }

}