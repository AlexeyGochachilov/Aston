package third.beverageMachines;

import third.chainOfResponsibilities.CoffeeType;
import third.decorator.DecoratedCoffeeFactory;
import third.decorator.Size;
import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static third.Constants.PLEASE_SELECT_COFFEE;
import static third.Constants.PUT_DOWN_CUP;

public class CoffeeMachine extends BeverageMachine{

    protected List<Topping> toppings;
    private Size selectedSize;

    public CoffeeMachine() {
        this.toppings = new LinkedList<>();
        this.selectedSize = Size.MEDIUM;
    }

    public void selectCoffee(CoffeeStrategy coffeeStrategy) {
        super.selectBeverage(coffeeStrategy);
        this.toppings.clear();
    }

    public void selectCoffee(CoffeeType type, Size size) {
        switch (type) {
            case BLACK_COFFEE:
                super.beverageStrategy = DecoratedCoffeeFactory.createBlackCoffee(size);
                break;
            case CAPPUCCINO:
                super.beverageStrategy = DecoratedCoffeeFactory.createCappuccino(size);
                break;
            case LATTE:
                super.beverageStrategy = DecoratedCoffeeFactory.createLatte(size);
                break;
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
        this.selectedSize = size;
        this.toppings.clear();
        System.out.printf("Selected %s in %s size%n", type, size.getDisplayName());
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.selectedSize = size;
        if (super.beverageStrategy != null) {
            super.beverageStrategy = DecoratedCoffeeFactory.decorateWithSize(super.beverageStrategy, size);
            System.out.printf("Size updated to: %s%n", size.getDisplayName());
        }
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }

    public void startPreparingCoffee() {
        if (super.beverageStrategy == null) {
            System.out.println(PLEASE_SELECT_COFFEE);
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        super.beverageStrategy.prepare(new LinkedList<>(toppings));
        toppings.clear();
    }
}
