package ru.geekbrains.lesson8.examples;

import javax.swing.*;
import java.awt.*;

public class Example1 {

    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setSize(400, 400);
            getContentPane().setBackground(new Color(105, 98, 222));
//            setLocation(300, 150);
//            setBounds(600, 150, 400, 200);
            setVisible(true);
        }
    }

    private static class WindowRunnable implements /* extends */ Runnable {

        @Override
        public void run() {
            new MyWindow();
        }
    }

    public static void main(String[] args) {
//        MyWindow mainWindow = new MyWindow();
//        JFrame secondWindow = new JFrame();
//        secondWindow.setLocationRelativeTo(mainWindow);
//        secondWindow.setSize(150, 75);
//        secondWindow.setVisible(true);

//        EventQueue.invokeLater(new WindowRunnable());
        EventQueue.invokeLater(() -> new MyWindow());

    }


}
