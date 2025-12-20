package third.decorator;

import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.List;

public class SizeDecorator implements CoffeeStrategy {

    private final CoffeeStrategy decoratedStrategy;
    private final Size size;
    private double sizeCostAdjustment;

    public SizeDecorator(CoffeeStrategy decoratedStrategy, Size size) {
        if (decoratedStrategy == null) {
            throw new IllegalArgumentException("Decorated strategy cannot be null");
        }
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.decoratedStrategy = decoratedStrategy;
        this.size = size;
        this.sizeCostAdjustment = calculateSizeCostAdjustment();
    }

    private double calculateSizeCostAdjustment() {
        // Базовая логика: стоимость увеличивается пропорционально размеру
        return (size.getCostMultiplier() - 1.0) * 0.5; // Пример расчета
    }

    @Override
    public void prepare(List<Topping> toppings) {
        prepareSizeSpecificActions();
        decoratedStrategy.prepare(toppings);
        completeSizeSpecificActions();
    }

    private void prepareSizeSpecificActions() {
        System.out.println("╔═══════════════════════════════════════");
        System.out.printf("║ size: %s%n", size.getDisplayName());
        System.out.printf("║ volume: %d ml%n", size.getCapacityMl());
        System.out.println("╠═══════════════════════════════════════");
    }

    private void completeSizeSpecificActions() {
        System.out.println("╠═══════════════════════════════════════");
        System.out.printf("║ Additional payment for the size: %.2f$%n", sizeCostAdjustment);
        System.out.println("╚═══════════════════════════════════════");
    }

    public SizeableCoffee createSizeableCoffee(List<Topping> toppings) {
        return new SizeableCoffee() {
            @Override
            public void prepareWithSize() {
                prepare(toppings);
            }

            @Override
            public String getDescription() {
                return String.format("Coffee in %s cup (%d ml)", size.getDisplayName(), size.getCapacityMl());
            }

            @Override
            public double getCost() {
                return 2.5 + sizeCostAdjustment;
            }

            @Override
            public Size getSize() {
                return size;
            }
        };
    }

    public CoffeeStrategy getDecoratedStrategy() {
        return decoratedStrategy;
    }

    public Size getSize() {
        return size;
    }

    public double getSizeCostAdjustment() {
        return sizeCostAdjustment;
    }

    public static boolean isSizeDecorated(CoffeeStrategy strategy) {
        return strategy instanceof SizeDecorator;
    }

    public static CoffeeStrategy extractBaseStrategy(CoffeeStrategy strategy) {
        if (strategy instanceof SizeDecorator) {
            return ((SizeDecorator) strategy).getDecoratedStrategy();
        }
        return strategy;
    }
}
