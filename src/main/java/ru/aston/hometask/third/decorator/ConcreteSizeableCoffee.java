package ru.aston.hometask.third.decorator;

import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

import static ru.aston.hometask.third.Constants.BASE_COFFEE_PRICE;

public class ConcreteSizeableCoffee implements SizeableCoffee {

    private final SizeDecorator sizeDecorator;
    private final List<Topping> toppings;

    public ConcreteSizeableCoffee(SizeDecorator sizeDecorator, List<Topping> toppings) {
        if (sizeDecorator == null) {
            throw new IllegalArgumentException("SizeDecorator cannot be null");
        }
        this.sizeDecorator = sizeDecorator;
        this.toppings = toppings != null ? toppings : List.of();
    }

    @Override
    public void prepareWithSize() {
        sizeDecorator.prepare(toppings);
    }

    @Override
    public String getDescription() {
        return String.format("%s in %s cup (%d ml)",
                getCoffeeTypeName(),
                sizeDecorator.getSize().getDisplayName(),
                sizeDecorator.getSize().getCapacityMl());
    }

    @Override
    public double getCost() {
        return BASE_COFFEE_PRICE + sizeDecorator.getSizeCostAdjustment();
    }

    @Override
    public Size getSize() {
        return sizeDecorator.getSize();
    }

    private String getCoffeeTypeName() {
        return sizeDecorator.getBaseStrategy().getClass().getSimpleName()
                .replace("Strategy", "");
    }
}
