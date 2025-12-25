package ru.aston.hometask.third.strategy;

import ru.aston.hometask.third.beverageMachines.CoffeeMachine;
import ru.aston.hometask.third.strategy.coffee.BlackCoffeeStrategy;
import ru.aston.hometask.third.strategy.coffee.CappuccinoStrategy;
import ru.aston.hometask.third.strategy.coffee.CoffeeFactory;
import ru.aston.hometask.third.strategy.topping.Milk;
import ru.aston.hometask.third.strategy.topping.Sugar;
import ru.aston.hometask.third.strategy.topping.Syrup;

import static ru.aston.hometask.third.Constants.SEPARATOR_LINE;

public class ShowStrategy {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.selectCoffee(new BlackCoffeeStrategy());
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectCoffee(CoffeeFactory.createLatte(new Sugar()));
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectCoffee(new CappuccinoStrategy());
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();
    }
}
