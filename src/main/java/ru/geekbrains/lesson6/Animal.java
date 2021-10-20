package ru.geekbrains.lesson6;

abstract class Animal extends Counter{
    protected String name;
    protected String color;
    protected Integer age;
    protected Integer maxRunLength;
    protected Integer maxSwimLength;

    public Animal(String name, String color, Integer age, Integer maxRunLength, Integer maxSwimLength) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxRunLength = maxRunLength;
        this.maxSwimLength = maxSwimLength;
    }

    public abstract void run (int length);

    public abstract void swim (int length);
}
