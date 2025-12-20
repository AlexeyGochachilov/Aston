package third.decorator;

import third.beverageMachines.CoffeeMachine;
import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CappuccinoStrategy;
import third.strategy.topping.Milk;
import third.strategy.topping.Sugar;
import third.strategy.topping.Syrup;

import static third.Constants.SEPARATOR_LINE;

public class ShowDecorator {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createBlackCoffee(Size.LARGE));
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectCoffee(new CappuccinoStrategy());
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.setSize(Size.SMALL);
        coffeeMachine.startPreparingCoffee();

        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createLatte(Size.MEDIUM));
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();

        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createLatte(Size.LARGE));
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATOR_LINE);

        SizeableCoffee sizeableCoffee = DecoratedCoffeeFactory.createSizeableCoffee(
                new BlackCoffeeStrategy(),
                Size.EXTRA_LARGE,
                new Milk(), new Sugar()
        );
        System.out.println("Description: " + sizeableCoffee.getDescription());
        System.out.printf("Cost: $%.2f%n", sizeableCoffee.getCost());
        System.out.println("Size: " + sizeableCoffee.getSize());
        System.out.println("\nPreparing...");
        sizeableCoffee.prepareWithSize();
    }
}
