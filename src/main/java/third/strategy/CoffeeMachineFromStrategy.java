package third.strategy;

import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static third.Constants.PLEASE_SELECT_COFFEE;
import static third.Constants.PUT_DOWN_CUP;

public class CoffeeMachineFromStrategy {

    private CoffeeStrategy coffeeStrategy;
    private final List<Topping> toppings;

    public CoffeeMachineFromStrategy() {
        this.toppings = new LinkedList<>();
    }

    public void selectCoffee(CoffeeStrategy coffeeStrategy) {
        this.coffeeStrategy = coffeeStrategy;
        this.toppings.clear();
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }

    public void startPreparingCoffee() {
        if (coffeeStrategy == null) {
            System.out.println(PLEASE_SELECT_COFFEE);
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        coffeeStrategy.prepare(new LinkedList<>(toppings));
        toppings.clear();
    }
}
