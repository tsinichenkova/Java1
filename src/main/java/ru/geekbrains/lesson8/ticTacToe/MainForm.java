package ru.geekbrains.lesson8.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm(Game game) {
        setBounds(300, 300, 500, 500);
        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        add(game, BorderLayout.CENTER);
        JButton jButtonStartGame = new JButton("Начать новую игру");
        add(jButtonStartGame, BorderLayout.SOUTH);

        jButtonStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingsForm settingsForm = new SettingsForm(game);
            }
        });

        setVisible(true);

    }
}
