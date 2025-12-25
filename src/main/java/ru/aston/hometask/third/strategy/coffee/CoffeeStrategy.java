package ru.aston.hometask.third.strategy.coffee;

import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

public interface CoffeeStrategy {

    void prepare(List<Topping> toppings);
}
