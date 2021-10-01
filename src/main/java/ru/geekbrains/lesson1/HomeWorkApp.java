package ru.geekbrains.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        String[] fruits = {"Orange", "Banana", "Apple"};
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

    public static void checkSumSign() {
        int a = 5;
        int b = -11;
        int c = a + b;
        if (c > 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 5;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

}

