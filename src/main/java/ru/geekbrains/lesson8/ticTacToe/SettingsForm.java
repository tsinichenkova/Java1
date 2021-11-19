package ru.geekbrains.lesson8.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsForm extends JFrame {

    private static final int defaultSize = 3;
    private static final int defaultDotsToWin = 3;
    SettingsForm settingsForm = this;

    public  SettingsForm (Game game) {
        setBounds(300, 300, 500, 500);
        setTitle("Настройка игры в крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel jLabelSize = new JLabel("Введите размер поля (по умолчанию 3 * 3): ");
        add(jLabelSize);

        JTextField jTextFieldSize = new JTextField();
        jTextFieldSize.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldSize);

        JLabel jLabelDotsToWin = new JLabel("Введите количество строк для победы (по умолчанию 3): ");
        add(jLabelDotsToWin);

        JTextField jTextFieldDotsToWin = new JTextField();
        jTextFieldDotsToWin.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldDotsToWin);

        JButton jButtonStartGame = new JButton("Начать игру");
        add(jButtonStartGame);

        setVisible(true);

        jButtonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jTextFieldSize.getText().isEmpty()) {
                    game.setSizeCount(defaultSize);
                } try {
                    game.setSizeCount(Integer.parseInt(jTextFieldSize.getText()));
                }
                catch (NumberFormatException ex) {
                    System.out.println("Необходимо ввести число");
                }

                if (jTextFieldDotsToWin.getText().isEmpty()) {
                    game.setDotsToWin(defaultDotsToWin);
                } try {
                    game.setDotsToWin(Integer.parseInt(jTextFieldDotsToWin.getText()));
                }
                catch (NumberFormatException ex) {
                    System.out.println("Необходимо ввести число");
                }
//                game.startNewGame();
//                MainForm mainForm = new MainForm(game);
//                mainForm.setVisible(true);
                game.startNewGame();
                settingsForm.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new SettingsForm(new Game());
    }
}
