package ru.aston.hometask.third.strategy.coffee;

public class CappuccinoStrategy extends BaseCoffeeStrategy {

    @Override
    protected void brewCoffee() {
        System.out.println("Preparing Cappuccino");
    }
}
