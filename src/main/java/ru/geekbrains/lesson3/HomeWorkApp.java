package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {

        System.out.println("1 задание:");
        invertArray();

        System.out.println("\n2 задание:");
        fillArray();

        System.out.println("\n3 задание:");
        changeArray();

        System.out.println("\n4 задание:");
        fillTwoDimArray(6);

        System.out.println("\n5 задание:");
        System.out.println(Arrays.toString(createArray(10, 5)));

        System.out.println("\n6 задание:");
        int[] array = createRandomArray(10, 10);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(findMinAndMaxValue(array)));

        System.out.println("\n7 задание:");
        System.out.println(checkBalance(array));

        System.out.println("\n8 задание:");
        System.out.println(Arrays.toString(shiftArray(array, 2)));

    }

    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 - array[i];
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillTwoDimArray(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
            arr[i][size - i - 1] = 1;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static int[] findMinAndMaxValue(int[] array) {
        int[] minAndMaxValue = {array[0], array[0]};
        for (int i : array) {
            if (i < minAndMaxValue[0])
                minAndMaxValue[0] = i;
            if (i > minAndMaxValue[1])
                minAndMaxValue[1] = i;
        }
        return minAndMaxValue;
    }

    public static boolean checkBalance(int[] array) {
        int sumArray = 0;
        int sumLeft = 0;
        for (int i : array) {
            sumArray += i;
        }
        for (int i = 0; i < array.length - 1; i++) {
            sumLeft += array[i];
            if (sumLeft * 2 == sumArray)
                return true;
        }
        return false;
    }

    public static int[] shiftArray(int[] array, int n) {
        if (n == 0 || n % array.length == 0)
            return array;
        if (n < 0)
            n += array.length;
        for (int i = 0; i < n; i++) {
            int tmp = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--)
                array[j] = array[j - 1];
            array[0] = tmp;
        }
        return array;
    }


    public static int[] createRandomArray(int len, int bound) {
        int[] array = new int[len];
        Random rand = new Random();
        for (int i = 0; i < len; i++) {
            array[i] = rand.nextInt(bound);
        }
        return array;
    }

}

