package ru.geekbrains.lesson8.ticTacToe;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game2 extends JPanel {
    private static final String AI_WIN_MSG = "Победил компьютер!";
    private static final String HUMAN_WIN_MSG = "Победил человек!";
    private static final String DRAW_MSG = "Ничья!";

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '*';
    public static final int FIELD_SIZE = 450;

    private static int sizeCount = 3;
    private static int dotsToWin = 3;
    private static int cellSize;

    private static char[][] map;
    private static Scanner scanner;
    private static Random random;

    public void setSizeCount(int size) {
        this.sizeCount = size;
    }

    public void setDotsToWin(int dotsToWin) {
        this.dotsToWin = dotsToWin;
    }

    public void startNewGame() {
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        repaint();
        setVisible(true);

        startGameLoop();
    }

    private void startGameLoop() {
        while (true) {
            humanTurn();
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

    private static boolean checkEndGame(char symbol) {
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

    private static String getWinMessageBy(char symbol) {
        return symbol == DOT_X ? HUMAN_WIN_MSG : AI_WIN_MSG;
    }

    private static boolean isWin(char symbol) {
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

    private static int checkLine(char symbol, int count, int row, int col) {
        if (map[row][col] == symbol) {
            count++;
        } else if (map[row][col] != symbol && count < dotsToWin) {
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

        map[row][col] = DOT_O;
        printAIStep(row, col);
    }

    private static void printAIStep(int row, int col) {
        System.out.println("Компьютер сходил в координаты: " + (row + 1) + " " + (col + 1));
    }

    private static boolean findWinningStep(char symbol) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                if (map[row][col] == DOT_EMPTY) {
                    map[row][col] = symbol;
                    if (isWin(symbol)) {
                        map[row][col] = DOT_O;
                        printAIStep(row, col);
                        return true;
                    }
                    if (!isWin(symbol)) {
                        map[row][col] = DOT_EMPTY;
                    }
                }
            }
        }
        return false;
    }

    private static void humanTurn() {
        System.out.println("Введите координаты row col: ");
        int row = 0;
        int col = 0;
        do {
            row = readIndex();
            col = readIndex();

            if (!checkRange(row) || !checkRange(col)) {
                System.out.println("Координаты должны быть в диапазоне от 1 до " + sizeCount);
                continue;
            }

            if (isEmptyCell(row - 1, col - 1)) {
                break;
            } else {
                System.out.println("Клетка уже занята!");
            }

        } while (true);

        map[row - 1][col - 1] = DOT_X;
    }

    private static boolean isEmptyCell(int row, int col) {
        return map[row][col] == DOT_EMPTY;
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

    private static void initMap() {
        cellSize = FIELD_SIZE / sizeCount;
        map = new char[sizeCount][sizeCount];

        for (int row = 0; row < map.length; row++) {
            Arrays.fill(map[row], DOT_EMPTY);
        }
    }

    private static void printMap() {
        printMapHeader();
        printMapState();
        System.out.println();
    }

    private static void printMapState() {
        for (int row = 0; row < map.length; row++) {
            printRowNumber(row);
            printRow(map[row]);
            System.out.println();
        }
    }

    private static void printRow(char[] chars) {
        for (int col = 0; col < chars.length; col++) {
            System.out.print(chars[col] + " ");
        }
    }

    private static void printRowNumber(int rowNumber) {
        System.out.print((rowNumber + 1) + " ");
    }

    private static void printMapHeader() {
        for (int col = 0; col <= sizeCount; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
    }


//    @Override
//    public void paintComponent(Graphics graphics) {
//        super.paintComponent(graphics);
//        for (int i = 0; i <= sizeCount; i++) {
//            graphics.drawLine(0, i * cellSize, FIELD_SIZE, i * cellSize);
//            graphics.drawLine(i * cellSize, 0, i * cellSize, FIELD_SIZE);
//        }
//
//        for (int i = 0; i < sizeCount; i++) {
//            for (int j = 0; j < sizeCount; j++) {
//                if (map[i][j] != DOT_EMPTY) {
//                    if (map[i][j] == DOT_X) {
//                        Graphics2D g2d = (Graphics2D) graphics;
//                        g2d.setStroke(new BasicStroke(10));
//                        g2d.setColor(Color.BLUE);
//                        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
//                        g2d.drawLine(this.getWidth(), 0,  0, this.getHeight());
//                    }
//                    if (map[i][j] == DOT_O) {
//                        graphics.drawOval(0, this.getHeight() / 4, getWidth(), getWidth());
//                        graphics.setColor(Color.RED);
//                        graphics.fillOval(0, this.getHeight() / 4, getWidth(), getWidth());
//                    }
//                }
//            }
//        }
//    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i <= sizeCount; i++) {
            graphics.drawLine(0, i * cellSize, FIELD_SIZE, i * cellSize);
            graphics.drawLine(i * cellSize, 0, i * cellSize, FIELD_SIZE);
        }

        for (int i = 0; i < sizeCount; i++) {
            for (int j = 0; j < sizeCount; j++) {
                if (map[i][j] != DOT_EMPTY) {
                    if (map[i][j] == DOT_X) {
                        Graphics2D g2d = (Graphics2D) graphics;
                        g2d.setStroke(new BasicStroke(10));
                        g2d.setColor(Color.BLUE);
                        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
                        g2d.drawLine(this.getWidth(), 0,  0, this.getHeight());
                    }
                    if (map[i][j] == DOT_O) {
                        graphics.drawOval(0, this.getHeight() / 4, getWidth(), getWidth());
                        graphics.setColor(Color.RED);
                        graphics.fillOval(0, this.getHeight() / 4, getWidth(), getWidth());
                    }
                }
            }
        }
    }
}
