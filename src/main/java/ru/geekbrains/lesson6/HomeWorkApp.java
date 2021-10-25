package ru.geekbrains.lesson6;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) throws Exception {
        Animal catBarsik = new Cat("Барсик", "Белый", 1, 100, 50);
        Animal catMursik = new Cat("Мурзик", "Черный", 2, 150, 10);
        Animal dogRichi = new Dog("Ричи", "Рыжий", 1, 500, 100);
        Animal dogViksi = new Dog("Викси", "Бело-черный", 1, 400, 80);
        Animal dogHarli = new Dog("Харли", "Белая", 2, 300, 50);

        Animal[] animals = {catBarsik, catMursik, dogRichi, dogViksi, dogHarli};
        for (Animal animal : animals) {
            canRun(animal, getRandomNumber(500));
            canSwim(animal, getRandomNumber(100));
        }

        System.out.println("Создано котов: " + catBarsik.getTotalCount());
        System.out.println("Создано собак: " + dogRichi.getTotalCount());
    }

    private static void canRun(Animal animal, int length) {
        animal.run(length);
    }

    private static void canSwim(Animal animal, int length) {
        animal.swim(length);
    }

    private static int getRandomNumber (int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
}

