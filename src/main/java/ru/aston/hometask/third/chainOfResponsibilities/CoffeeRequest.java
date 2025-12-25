package ru.aston.hometask.third.chainOfResponsibilities;

import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

public class CoffeeRequest {

    private final CoffeeType coffeeType;
    private final List<Topping> toppings;
    private String specialInstructions;

    public CoffeeRequest(CoffeeType coffeeType, List<Topping> toppings) {
        if (coffeeType == null) {
            throw new IllegalArgumentException("Coffee type cannot be null");
        }
        this.coffeeType = coffeeType;
        this.toppings = toppings != null ? new LinkedList<>(toppings) : new LinkedList<>();
        this.specialInstructions = "";
    }

    public CoffeeRequest(CoffeeType coffeeType) {
        this(coffeeType, null);
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }


    public List<Topping> getToppings() {
        return new LinkedList<>(toppings);
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }

    public void setSpecialInstructions(String instructions) {
        this.specialInstructions = instructions != null ? instructions : "";
    }

    public boolean containsTopping(Class<? extends Topping> toppingClass) {
        return toppings.stream()
                .anyMatch(topping -> toppingClass.isInstance(topping));
    }

    @Override
    public String toString() {
        return String.format("CoffeeRequest{type=%s, toppings=%d, instructions='%s'}",
                coffeeType.getDisplayName(), toppings.size(), specialInstructions);
    }
}
