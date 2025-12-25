package ru.aston.hometask.third.strategy.coffee;

import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

public abstract class BaseCoffeeStrategy implements CoffeeStrategy {

    public final void prepare(List<Topping> toppings) {
        addToppingsToCoffee(toppings);
        brewCoffee();
    }

    protected void addToppingsToCoffee(List<Topping> toppings) {
        if(toppings != null){
            toppings.forEach(Topping::addTopping);
        }
    }

    protected abstract void brewCoffee();
}
