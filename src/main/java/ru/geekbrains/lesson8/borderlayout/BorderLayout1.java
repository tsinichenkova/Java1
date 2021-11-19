package ru.geekbrains.lesson8.borderlayout;

import javax.swing.*;
import java.awt.*;

public class BorderLayout1 {

    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setSize(800, 800);
            setLocationRelativeTo(null);

            JButton button = new JButton("Button 1 (PAGE_START)");
            add(button, BorderLayout.PAGE_START);

            button = new JButton("Button 2 (CENTER)");
            add(button, BorderLayout.CENTER);

            button = new JButton("Button 3 (LINE_START)");
//            button.setSize(new Dimension(200, 200));
            add(button, BorderLayout.LINE_START);

            button = new JButton("Long-Named Button 4 (PAGE_END)");
            add(button, BorderLayout.PAGE_END);

            button = new JButton("5 (LINE_END)");
            add(button, BorderLayout.LINE_END);

            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }

}