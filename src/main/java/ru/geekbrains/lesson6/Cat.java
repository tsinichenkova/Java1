package ru.geekbrains.lesson6;

public class Cat extends Animal {
    public Cat(String name, String color, Integer age, Integer maxRunLength, Integer maxSwimLength) {
        super(name, color, age, maxRunLength, maxSwimLength);
    }

    @Override
    public void run(int length) {
        if (length >= 0 && length <= maxRunLength) {
            System.out.printf("Кот %s пробежал %d метров", name, length);
        } else {
            System.out.printf("Кот %s не может пробежать %d метров", name, length);
        }
        System.out.println();
    }

    @Override
    public void swim(int length) {
        System.out.println("Коты не умеют плавать");
    }
}
