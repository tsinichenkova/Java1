package ru.geekbrains.lesson7;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int foodCount) {
        if (food >= foodCount) {
            this.food -= foodCount;
        }
        else System.out.println("Коту не хватило еды");
    }

    public void increaseFood(int foodCount) {
        this.food += foodCount;
    }

    public boolean isEnoughFood(int foodCount) {
        return foodCount <= this.food;
    }

    public void info() {
        System.out.println("Количество еды в тарелке: " + food);
    }
}
