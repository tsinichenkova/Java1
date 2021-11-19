package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterExample {

    private static int counter = 0;
    private static int step = 1;
    private static JLabel counterValueView;
    private static JTextField field;

    public static void main(String[] args) {
        JFrame mainFrame = initFrame();

        Font font = new Font("Arial", Font.PLAIN, 32);

        createCounterView(mainFrame, font);
        createTextField(mainFrame, font);
        createButtons(mainFrame, font);

        mainFrame.setVisible(true);
    }

    private static void createButtons(JFrame mainFrame, Font font) {
        JButton decrementButton = new JButton("<");
        decrementButton.setFont(font);
        mainFrame.add(decrementButton, BorderLayout.LINE_START);

        JButton incrementButton = new JButton(">");
        incrementButton.setFont(font);
        mainFrame.add(incrementButton, BorderLayout.LINE_END);

        JButton clearButton = new JButton("Очистить");
        clearButton.setFont(font);
        mainFrame.add(clearButton, BorderLayout.PAGE_END);

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter -= step;
                refreshCounterValueView(counter);
            }
        });
        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter += step;
                refreshCounterValueView(counter);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter = 0;
                step = 1;
                refreshCounterValueView(counter);
                field.setText(String.valueOf(step));
            }
        });
    }

    private static void createTextField(JFrame mainFrame, Font font) {
        field = new JTextField();
        field.setFont(font);
        mainFrame.add(field, BorderLayout.PAGE_START);

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                step = Integer.parseInt(field.getText());
            }
        });
    }


    private static JFrame initFrame() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Counter");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setBounds(300, 300, 400, 200);
        return mainFrame;
    }

    private static void createCounterView(JFrame mainFrame, Font font) {
        counterValueView = new JLabel(getCounterValueAsText());
        counterValueView.setHorizontalAlignment(SwingConstants.CENTER);
        counterValueView.setFont(font);
        mainFrame.add(counterValueView, BorderLayout.CENTER);
    }

    private static String getCounterValueAsText() {
        return String.valueOf(counter);
    }

    private static void refreshCounterValueView(Integer count) {
        counterValueView.setText(String.valueOf(count));
    }
}
