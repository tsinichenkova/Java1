package ru.geekbrains.lesson8.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game extends JFrame {
    private static final String AI_WIN_MSG = "Победил компьютер!";
    private static final String HUMAN_WIN_MSG = "Победил человек!";
    private static final String DRAW_MSG = "Ничья!";

    private static final String DOT_X = "X";
    private static final String DOT_O = "0";
    private static final String DOT_EMPTY = "*";

    private static int sizeCount = 3;
    private static int dotsToWin = 3;
    private static int cellSize;

    private static JButton[][] map;
    private static Scanner scanner;
    private static Random random;

    public Game() {
        setBounds(300, 300, 500, 500);
        setTitle("Крестики нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setLayout(new GridLayout(sizeCount, sizeCount));

        map = new JButton[sizeCount][sizeCount];

        for (int i = 0; i < sizeCount; i++) {
            for (int j = 0; j < sizeCount; j++) {
                map[i][j] = createButton(i, j);
                add(map[i][j]);
            }
        }
    }

    private JButton createButton(int i, int j) {
        JButton jButton = new JButton();
        jButton.putClientProperty("INDEX", new Integer[]{i, j});
        jButton.putClientProperty("OWNER", DOT_EMPTY);
        jButton.setEnabled(true);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton.putClientProperty("OWNER", DOT_X);
                jButton.setText(DOT_X);
                jButton.setEnabled(false);
                aiTurn();

            }
        });
        return jButton;
    }



    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        for (int i = 0; i < sizeCount; i++) {
            for (int j = 0; j < sizeCount; j++) {
                map[i][j].setText(map[i][j].getClientProperty("OWNER").toString());
            }
        }
    }

    public void setSizeCount(int size) {
        this.sizeCount = size;
    }

    public void setDotsToWin(int dotsToWin) {
        this.dotsToWin = dotsToWin;
    }

    public void startNewGame() {
        scanner = new Scanner(System.in);
        random = new Random();

        repaint();
        setVisible(true);

//        startGameLoop();
    }

    private void startGameLoop() {
        while (true) {
//            humanTurn();
            repaint();
            if (checkEndGame(DOT_X)) {
                break;
            }

            aiTurn();
            repaint();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }

    private void humanTurn() {
        while (true) {
//            humanTurn();
            repaint();
            if (checkEndGame(DOT_X)) {
                break;
            }

            aiTurn();
            repaint();
            if (checkEndGame(DOT_O)) {
                break;
            }
        }
    }


    private static boolean checkEndGame(String symbol) {
        if (isMapFull()) {
            System.out.println(DRAW_MSG);
            return true;
        }

        if (isWin(symbol)) {
            System.out.println(getWinMessageBy(symbol));
            return true;
        }
        return false;
    }

    private static String getWinMessageBy(String symbol) {
        return symbol.equals(DOT_X) ? HUMAN_WIN_MSG : AI_WIN_MSG;
    }

    private static boolean isWin(String symbol) {
        int countRow, countCol, countDiagonalA, countDiagonalB;

        for (int row = 0; row < map.length; row++) {
            countRow = 0;
            countCol = 0;
            countDiagonalA = 0;
            countDiagonalB = 0;

            for (int col = 0; col < map[row].length; col++) {
                countRow = checkLine(symbol, countRow, row, col);
                countCol = checkLine(symbol, countCol, col, row);
                countDiagonalA = checkLine(symbol, countDiagonalA, col, col);
                countDiagonalB = checkLine(symbol, countDiagonalB, map.length - col - 1, col);
            }
            if (countRow >= dotsToWin || countCol >= dotsToWin || countDiagonalA >= dotsToWin || countDiagonalB >= dotsToWin) {
                return true;
            }
        }
        return false;
    }

    private static int checkLine(String symbol, int count, int row, int col) {
        if (map[row][col].getClientProperty("OWNER").equals(symbol)) {
            count++;
        } else if ((!map[row][col].getClientProperty("OWNER").equals(symbol)) && count < dotsToWin) {
            count = 0;
        }
        return count;
    }


    private static boolean isMapFull() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                if (isEmptyCell(row, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void aiTurn() {
        if (findWinningStep(DOT_O)) {
            return;
        } else if (findWinningStep(DOT_X)) {
            return;
        }

        int row, col;
        do {
            row = random.nextInt(sizeCount);
            col = random.nextInt(sizeCount);
        } while (!isEmptyCell(row, col));

        map[row][col].putClientProperty("OWNER", DOT_O);
        map[row][col].setEnabled(false);
        printAIStep(row, col);
    }

    private static void printAIStep(int row, int col) {
        System.out.println("Компьютер сходил в координаты: " + (row + 1) + " " + (col + 1));
    }

    private static boolean findWinningStep(String symbol) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                if (map[row][col].getClientProperty("OWNER").equals(DOT_EMPTY)) {
                    map[row][col].putClientProperty("OWNER", symbol);
                    ;
                    if (isWin(symbol)) {
                        map[row][col].putClientProperty("OWNER", DOT_O);
                        printAIStep(row, col);
                        return true;
                    }
                    if (!isWin(symbol)) {
                        map[row][col].putClientProperty("OWNER", DOT_EMPTY);
                    }
                }
            }
        }
        return false;
    }

//    private static void humanTurn() {
//        int row = 0;
//        int col = 0;
//        do {
//            row = readIndex();
//            col = readIndex();
//
//            if (!checkRange(row) || !checkRange(col)) {
//                System.out.println("Координаты должны быть в диапазоне от 1 до " + sizeCount);
//                continue;
//            }
//
//            if (isEmptyCell(row - 1, col - 1)) {
//                break;
//            } else {
//                System.out.println("Клетка уже занята!");
//            }
//
//        } while (true);
//
//        map[row - 1][col - 1] = DOT_X;
//    }

    private static boolean isEmptyCell(int row, int col) {
        return (map[row][col].getClientProperty("OWNER").equals(DOT_EMPTY));
    }

    private static int readIndex() {
        while (!scanner.hasNextInt()) {
            System.out.println("Координаты должны иметь целочисленное значение!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static boolean checkRange(int index) {
        return index >= 1 && index <= sizeCount;
    }

//    private static void printMap() {
//        printMapHeader();
//        printMapState();
//        System.out.println();
//    }
//
//    private static void printMapState() {
//        for (int row = 0; row < map.length; row++) {
//            printRowNumber(row);
//            printRow(map[row]);
//            System.out.println();
//        }
//    }
//
//    private static void printRow(char[] chars) {
//        for (int col = 0; col < chars.length; col++) {
//            System.out.print(chars[col] + " ");
//        }
//    }
//
//    private static void printRowNumber(int rowNumber) {
//        System.out.print((rowNumber + 1) + " ");
//    }
//
//    private static void printMapHeader() {
//        for (int col = 0; col <= sizeCount; col++) {
//            System.out.print(col + " ");
//        }
//        System.out.println();
//    }
}
