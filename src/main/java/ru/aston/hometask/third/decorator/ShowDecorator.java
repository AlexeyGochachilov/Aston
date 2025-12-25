package ru.aston.hometask.third.decorator;

import ru.aston.hometask.third.beverageMachines.CoffeeMachine;
import ru.aston.hometask.third.strategy.coffee.BlackCoffeeStrategy;
import ru.aston.hometask.third.strategy.coffee.CappuccinoStrategy;
import ru.aston.hometask.third.strategy.topping.Milk;
import ru.aston.hometask.third.strategy.topping.Sugar;
import ru.aston.hometask.third.strategy.topping.Syrup;

import static ru.aston.hometask.third.Constants.SEPARATOR_LINE;

public class ShowDecorator {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createBlackCoffee(Size.LARGE));
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println("\n" + SEPARATOR_LINE);

        coffeeMachine.selectCoffee(new CappuccinoStrategy());
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.setSize(Size.SMALL);
        coffeeMachine.startPreparingCoffee();

        System.out.println("\n" + SEPARATOR_LINE);

        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createLatte(Size.MEDIUM));
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();

        System.out.println("\n---");

        coffeeMachine.selectCoffee(DecoratedCoffeeFactory.createLatte(Size.LARGE));
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();

        System.out.println("\n" + SEPARATOR_LINE);


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

