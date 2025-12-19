package third.strategy;

import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

public class CoffeeMachine {

    private CoffeeStrategy coffeeStrategy;
    private final List<Topping> toppings;
    private static final String PLEASE_SELECT_COFFEE = "Please firstly select a coffee";
    private static final String PUT_DOWN_CUP = "put down a paper cup";

    public CoffeeMachine() {
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
