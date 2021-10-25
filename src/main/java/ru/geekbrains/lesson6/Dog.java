package ru.geekbrains.lesson6;

public class Dog extends Animal {

    public Dog(String name, String color, Integer age, Integer maxRunLength, Integer maxSwimLength) {
        super(name, color, age, maxRunLength, maxSwimLength);
    }

    @Override
    public void run(int length) {
        if (length >= 0 && length <= maxRunLength) {
            System.out.printf("Собака %s пробежала %d метров", name, length);
        } else {
            System.out.printf("Собака %s не может пробежать %d метров", name, length);
        }
        System.out.println();
    }

    @Override
    public void swim(int length) {
        if (length >= 0 && length <= maxRunLength) {
            System.out.printf("Собака %s проплыла %d метров", name, length);
        } else {
            System.out.printf("Собака %s не может проплыть %d метров", name, length);
        }
        System.out.println();
    }
}
