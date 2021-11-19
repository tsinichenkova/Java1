package ru.geekbrains.lesson8.examples;

import javax.swing.*;
import java.awt.*;

public class Example2 {

    static class MyWindow extends JFrame {
        public MyWindow() {
            setTitle("Test Window");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setBounds(300, 300, 400, 400);

            JButton[] jbs = new JButton[5];
            for (int i = 0; i < 5; i++) {
                jbs[i] = new JButton("#" + i);
//                jbs[i].addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        System.out.println(((JButton)e.getSource()).getText() + " was pressed");
//                    }
//                });
            }
//            setLayout(new BorderLayout());   // выбор компоновщика элементов
            this.add(jbs[0], BorderLayout.EAST); // добавление кнопки на форму
            this.add(jbs[1], BorderLayout.WEST);
            this.add(jbs[2], BorderLayout.SOUTH);
            this.add(jbs[3], BorderLayout.NORTH);
            this.add(jbs[4], BorderLayout.CENTER);
            this.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new MyWindow();
    }

}
