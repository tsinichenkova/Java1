package ru.geekbrains.lesson2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println("Cумма лежит в пределах от 10 до 20: " + isNumberBetween10and20(5, 10));
        printCheckSign(-8);
        System.out.println("Число положительное: " + isPositiveNumber(5));
        printStringNnumerOfTime("Апельсин", 5);
        System.out.println("Год високосный: " + isLeapYear(2020));
    }

    public static boolean isNumberBetween10and20(int a, int b) {
        int c = a + b;
        return c >= 10 && c <= 20;
    }

    public static void printCheckSign(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static boolean isPositiveNumber(int a) {
        return a >= 0;
    }

    public static void printStringNnumerOfTime(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 400 == 0) || ((year % 4 == 0)) && (year % 100 != 0));
    }

}

