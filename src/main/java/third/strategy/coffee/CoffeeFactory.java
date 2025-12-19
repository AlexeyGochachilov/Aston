package third.strategy.coffee;

import third.strategy.topping.Topping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoffeeFactory {

    public static CoffeeStrategy createBlackCoffee(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = new LinkedList<>(Arrays.asList(toppings));
            if (dynamicToppings != null) {
                allToppings.addAll(dynamicToppings);
            }
            new BlackCoffeeStrategy().prepare(allToppings);
        };
    }

    public static CoffeeStrategy createCappuccino(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = new LinkedList<>(Arrays.asList(toppings));
            if (dynamicToppings != null) {
                allToppings.addAll(dynamicToppings);
            }
            new CappuccinoStrategy().prepare(allToppings);
        };
    }
    public static CoffeeStrategy createLatte(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = new LinkedList<>(Arrays.asList(toppings));
            if (dynamicToppings != null) {
                allToppings.addAll(dynamicToppings);
            }
            new LatteStrategy().prepare(allToppings);
        };
    }
}
