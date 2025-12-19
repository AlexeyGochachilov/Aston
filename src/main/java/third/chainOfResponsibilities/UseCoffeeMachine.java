package third.chainOfResponsibilities;

import third.chainOfResponsibilities.barista.BaristaChain;
import third.chainOfResponsibilities.barista.JuniorBarista;
import third.chainOfResponsibilities.barista.SeniorBarista;
import third.strategy.topping.Milk;
import third.strategy.topping.Sugar;
import third.strategy.topping.Syrup;

public class UseCoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.selectCoffee(CoffeeType.BLACK_COFFEE);
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        coffeeMachine.selectCoffee(CoffeeType.LATTE);
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.startPreparingCoffee();

        coffeeMachine.selectCoffee(CoffeeType.CAPPUCCINO);
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.startPreparingCoffee();

        coffeeMachine.selectCoffee(CoffeeType.BLACK_COFFEE);
        coffeeMachine.addTopping(new Sugar());
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.addTopping(new Syrup());
        coffeeMachine.addTopping(new Milk());
        coffeeMachine.startPreparingCoffee();

        BaristaChain customChain = new BaristaChain(new SeniorBarista());
        CoffeeMachine premiumMachine = new CoffeeMachine(customChain);

        premiumMachine.selectCoffee(CoffeeType.BLACK_COFFEE);
        premiumMachine.startPreparingCoffee();

        BaristaChain dynamicChain = new BaristaChain(
                new JuniorBarista(),
                new SeniorBarista()
        );

        coffeeMachine.setBaristaChain(dynamicChain);
        System.out.println(coffeeMachine.getBaristaChain().getChainInfo());

        coffeeMachine.selectCoffee(CoffeeType.CAPPUCCINO);
        coffeeMachine.startPreparingCoffee();

    }
}
