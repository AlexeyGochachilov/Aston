package ru.aston.hometask.third.chainOfResponsibilities;

import ru.aston.hometask.third.beverageMachines.CoffeeMachineForBarista;
import ru.aston.hometask.third.chainOfResponsibilities.barista.BaristaChain;
import ru.aston.hometask.third.chainOfResponsibilities.barista.JuniorBarista;
import ru.aston.hometask.third.chainOfResponsibilities.barista.SeniorBarista;
import ru.aston.hometask.third.strategy.topping.Milk;
import ru.aston.hometask.third.strategy.topping.Sugar;
import ru.aston.hometask.third.strategy.topping.Syrup;

public class ShowChainOfResponsibilities {
    public static void main(String[] args) {

        CoffeeMachineForBarista coffeeMachine = new CoffeeMachineForBarista();

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
        CoffeeMachineForBarista premiumMachine = new CoffeeMachineForBarista(customChain);

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
