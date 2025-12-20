package third.strategy;

import third.beverageMachines.CoffeeMachine;
import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CappuccinoStrategy;
import third.strategy.coffee.CoffeeFactory;
import third.strategy.topping.Milk;
import third.strategy.topping.Sugar;
import third.strategy.topping.Syrup;

import static third.Constants.SEPARATORLINE;

public class ShowStrategy {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.selectCoffee(new BlackCoffeeStrategy());
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATORLINE);

        coffeeMachine.selectCoffee(CoffeeFactory.createLatte(new Sugar()));
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        System.out.println(SEPARATORLINE);

        coffeeMachine.selectCoffee(new CappuccinoStrategy());
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();
    }
}
