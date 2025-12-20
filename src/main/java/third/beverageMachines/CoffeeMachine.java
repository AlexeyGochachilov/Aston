package third.beverageMachines;

import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static third.Constants.PLEASE_SELECT_COFFEE;
import static third.Constants.PUT_DOWN_CUP;

public class CoffeeMachine extends BeverageMachine{

    protected List<Topping> toppings;

    public CoffeeMachine() {
        this.toppings = new LinkedList<>();
    }

    public void selectCoffee(CoffeeStrategy coffeeStrategy) {
        super.selectBeverage(coffeeStrategy);
        this.toppings.clear();
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }

    public void startPreparingCoffee() {
        if (beverageStrategy == null) {
            System.out.println(PLEASE_SELECT_COFFEE);
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        beverageStrategy.prepare(new LinkedList<>(toppings));
        toppings.clear();
    }
}
