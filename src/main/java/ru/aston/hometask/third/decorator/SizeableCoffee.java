package ru.aston.hometask.third.decorator;

public interface SizeableCoffee {

    void prepareWithSize();

    String getDescription();

    double getCost();

    Size getSize();
}
