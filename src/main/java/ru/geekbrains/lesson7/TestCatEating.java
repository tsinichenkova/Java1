package ru.geekbrains.lesson7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TestCatEating {

    public static void main(String[] args) throws FileNotFoundException {
        Cat[] cats = prepareCats(5);
        Plate plate = new Plate(50);

        eat(cats, plate);
    }

    private static Cat[] prepareCats(int count) throws FileNotFoundException {
        List<String> names = getRandomName("nameCats.txt");
        Cat[] cats = new Cat[count];
        Random random = new Random();
        for (int i = 0; i < cats.length; i++) {
            cats[i] =  new Cat(names.get(random.nextInt(names.size())), random.nextInt(50));
        }
        return cats;
    }

    private static void eat (Cat[] cats, Plate plate) {
        for (Cat cat : cats) {
            plate.info();
            cat.eat(plate);
            cat.printInfo();
            System.out.println("---------------------");
        }
    }

    private static List<String> getRandomName(String path) throws FileNotFoundException {
        List<String> names = new ArrayList();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()) {
            names.add(scanner.next());
        }
        return names;
    }
}
