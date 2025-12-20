package third.decorator;

import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CappuccinoStrategy;
import third.strategy.coffee.CoffeeStrategy;
import third.strategy.coffee.LatteStrategy;
import third.strategy.topping.Topping;

public class DecoratedCoffeeFactory {

    public static CoffeeStrategy createBlackCoffee(Size size) {
        return new SizeDecorator(new BlackCoffeeStrategy(), size);
    }

    public static CoffeeStrategy createCappuccino(Size size) {
        return new SizeDecorator(new CappuccinoStrategy(), size);
    }

    public static CoffeeStrategy createLatte(Size size) {
        return new SizeDecorator(new LatteStrategy(), size);
    }

    public static CoffeeStrategy decorateWithSize(CoffeeStrategy strategy, Size size) {
        if (strategy == null || size == null) {
            throw new IllegalArgumentException("Strategy and size cannot be null");
        }
        if (SizeDecorator.isSizeDecorated(strategy)) {
            CoffeeStrategy base = SizeDecorator.extractBaseStrategy(strategy);
            return new SizeDecorator(base, size);
        }
        return new SizeDecorator(strategy, size);
    }

    public static SizeableCoffee createSizeableCoffee(CoffeeStrategy baseStrategy,
                                                      Size size,
                                                      Topping... toppings) {
        SizeDecorator decorator = new SizeDecorator(baseStrategy, size);
        return decorator.createSizeableCoffee(java.util.Arrays.asList(toppings));
    }
}
