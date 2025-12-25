package ru.aston.hometask.third.decorator;

import ru.aston.hometask.third.strategy.coffee.BlackCoffeeStrategy;
import ru.aston.hometask.third.strategy.coffee.CappuccinoStrategy;
import ru.aston.hometask.third.strategy.coffee.CoffeeStrategy;
import ru.aston.hometask.third.strategy.coffee.LatteStrategy;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DecoratedCoffeeFactory {

    private static final Map<String, Function<Size, CoffeeStrategy>> COFFEE_CREATORS = new HashMap<>();

    static {
        registerCoffeeCreator("BLACK_COFFEE", size -> new SizeDecorator(new BlackCoffeeStrategy(), size));

        registerCoffeeCreator("CAPPUCCINO", size -> new SizeDecorator(new CappuccinoStrategy(), size));

        registerCoffeeCreator("LATTE", size -> new SizeDecorator(new LatteStrategy(), size));
    }

    public static void registerCoffeeCreator(String coffeeType, Function<Size, CoffeeStrategy> creator) {
        COFFEE_CREATORS.put(coffeeType.toUpperCase(), creator);
    }

    public static CoffeeStrategy createCoffee(String coffeeType, Size size) {
        Function<Size, CoffeeStrategy> creator = COFFEE_CREATORS.get(coffeeType.toUpperCase());
        if (creator == null) {
            throw new IllegalArgumentException("Unknown coffee type: " + coffeeType);
        }
        return creator.apply(size);
    }

    public static CoffeeStrategy createBlackCoffee(Size size) {
        return createCoffee("BLACK_COFFEE", size);
    }

    public static CoffeeStrategy createCappuccino(Size size) {
        return createCoffee("CAPPUCCINO", size);
    }

    public static CoffeeStrategy createLatte(Size size) {
        return createCoffee("LATTE", size);
    }

    public static CoffeeStrategy decorateWithSize(CoffeeStrategy strategy, Size size) {
        if (strategy == null || size == null) {
            throw new IllegalArgumentException("Strategy and size cannot be null");
        }
        if (strategy instanceof SizeDecorator) {
            SizeDecorator existingDecorator = (SizeDecorator) strategy;
            CoffeeStrategy base = existingDecorator.getBaseStrategy();
            return new SizeDecorator(base, size);
        }
        if (CoffeeDecorator.isDecorated(strategy)) {
            CoffeeDecorator decorator = (CoffeeDecorator) strategy;
            CoffeeStrategy base = decorator.getBaseStrategy();
            return new SizeDecorator(strategy, size);
        }
        return new SizeDecorator(strategy, size);
    }

    public static SizeableCoffee createSizeableCoffee(CoffeeStrategy baseStrategy,
                                                      Size size,
                                                      Topping... toppings) {
        SizeDecorator decorator = new SizeDecorator(baseStrategy, size);
        return decorator.toSizeableCoffee(List.of(toppings));
    }
}
