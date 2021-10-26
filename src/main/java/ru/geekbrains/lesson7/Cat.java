package ru.geekbrains.lesson7;

public class Cat {

    private final int appetite;
    private final String name;
    private boolean fullness;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void eat(Plate plate) {
        checkFood(plate);
        plate.decreaseFood(appetite);
        this.fullness = true;
        System.out.printf("Кот %s поел", name);
        System.out.println();
    }

    public void checkFood(Plate plate) {
        if (!plate.isEnoughFood(appetite)) {
            System.out.println("В тарелку добавили еды: " + appetite);
            plate.increaseFood(appetite);
        }
    }

    public void printInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite='" + appetite + '\'' +
                ", fullness=" + fullness +
                '}';
    }
}
