package ru.aston.hometask.third.strategy.coffee;

public class LatteStrategy extends BaseCoffeeStrategy {

    @Override
    protected void brewCoffee() {
        System.out.println("Preparing Latte");
    }
}
