package third.strategy;

import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CappuccinoStrategy;
import third.strategy.coffee.CoffeeFactory;
import third.strategy.topping.Milk;
import third.strategy.topping.Sugar;
import third.strategy.topping.Syrup;

public class UseCoffeeMachine {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.selectCoffee(new BlackCoffeeStrategy());
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println("---------------------------");

        coffeeMachine.selectCoffee(CoffeeFactory.createLatte(new Sugar()));
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println("---------------------------");

        coffeeMachine.selectCoffee(new CappuccinoStrategy());
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();
    }
}
