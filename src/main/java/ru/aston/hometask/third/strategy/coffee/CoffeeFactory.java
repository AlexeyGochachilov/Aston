package ru.aston.hometask.third.strategy.coffee;

import ru.aston.hometask.third.chainOfResponsibilities.CoffeeType;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CoffeeFactory {

    public static CoffeeStrategy createBlackCoffee(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = combineToppings(toppings, dynamicToppings);
            new BlackCoffeeStrategy().prepare(allToppings);
        };
    }

    public static CoffeeStrategy createCappuccino(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = combineToppings(toppings, dynamicToppings);
            new CappuccinoStrategy().prepare(allToppings);
        };
    }

    public static CoffeeStrategy createLatte(Topping ... toppings) {
        return dynamicToppings -> {
            List<Topping> allToppings = combineToppings(toppings, dynamicToppings);
            new LatteStrategy().prepare(allToppings);
        };
    }

    private static List<Topping> combineToppings(Topping[] fixedToppings, List<Topping> dynamicToppings) {
        List<Topping> allToppings = new LinkedList<>(Arrays.asList(fixedToppings));
        if (dynamicToppings != null && !dynamicToppings.isEmpty()) {
            allToppings.addAll(dynamicToppings);
        }
        return allToppings;
    }

    public static CoffeeStrategy createByType(CoffeeType type) {
        return switch (type) {
            case BLACK_COFFEE -> createBlackCoffee();
            case CAPPUCCINO -> createCappuccino();
            case LATTE -> createLatte();
            default -> throw new IllegalArgumentException("Unknown coffee type: " + type);
        };
    }
}
