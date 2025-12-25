package ru.aston.hometask.third.decorator;

import ru.aston.hometask.third.strategy.coffee.CoffeeStrategy;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

public abstract class CoffeeDecorator implements CoffeeStrategy {

    protected final CoffeeStrategy decoratedStrategy;

    protected CoffeeDecorator(CoffeeStrategy decoratedStrategy) {
        if (decoratedStrategy == null) {
            throw new IllegalArgumentException("Decorated strategy cannot be null");
        }
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void prepare(List<Topping> toppings) {
        decoratedStrategy.prepare(toppings);
    }

    public CoffeeStrategy getBaseStrategy() {
        CoffeeStrategy strategy = decoratedStrategy;
        while (strategy instanceof CoffeeDecorator) {
            strategy = ((CoffeeDecorator) strategy).decoratedStrategy;
        }
        return strategy;
    }

    public static boolean isDecorated(CoffeeStrategy strategy) {
        return strategy instanceof CoffeeDecorator;
    }
}
