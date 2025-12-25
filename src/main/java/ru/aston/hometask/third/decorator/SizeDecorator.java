package ru.aston.hometask.third.decorator;

import ru.aston.hometask.third.strategy.coffee.CoffeeStrategy;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

import static ru.aston.hometask.third.Constants.*;

public class SizeDecorator extends CoffeeDecorator {

    private final Size size;

    public SizeDecorator(CoffeeStrategy decoratedStrategy, Size size) {
        super(decoratedStrategy);
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.size = size;
    }

    @Override
    public void prepare(List<Topping> toppings) {
        printSizeHeader();
        super.prepare(toppings);
        printSizeFooter();
    }

    private void printSizeHeader() {
        System.out.println(HEADER_LINE);
        System.out.printf("║ Size: %s%n", size.getDisplayName());
        System.out.printf("║ Volume: %d ml%n", size.getCapacityMl());
        System.out.println(MIDDLE_LINE);
    }

    private void printSizeFooter() {
        double sizeCostAdjustment = calculateSizeCostAdjustment();
        System.out.println(MIDDLE_LINE);
        System.out.printf("║ Size surcharge: %.2f$%n", sizeCostAdjustment);
        System.out.println(FOOTER_LINE);
    }

    private double calculateSizeCostAdjustment() {
        return (size.getCostMultiplier() - 1.0) * SIZE_COST_MULTIPLIER;
    }

    public SizeableCoffee toSizeableCoffee(List<Topping> toppings) {
        return new ConcreteSizeableCoffee(this, toppings);
    }

    public Size getSize() {
        return size;
    }

    public double getSizeCostAdjustment() {
        return calculateSizeCostAdjustment();
    }
}
