package third.beverageMachines;

import third.decorator.DecoratedCoffeeFactory;
import third.decorator.Size;
import third.decorator.SizeDecorator;
import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static third.Constants.*;

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

    public void selectCoffee(String coffeeType, Size size) {
        beverageStrategy = DecoratedCoffeeFactory.createCoffee(coffeeType, size);
        this.selectedSize = size;
        this.toppings.clear();
        System.out.printf("Selected %s in %s size%n", coffeeType, size.getDisplayName());
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.selectedSize = size;
        if (beverageStrategy != null) {
            beverageStrategy = DecoratedCoffeeFactory.decorateWithSize(beverageStrategy, size);
            System.out.printf("Size updated to: %s%n", size.getDisplayName());
        }
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
        List<Topping> toppingsCopy = new LinkedList<>(toppings);
        beverageStrategy.prepare(toppingsCopy);
        clearOrder();
    }

    public double calculateTotalCost() {
        if (beverageStrategy == null) {
            return 0.0;
        }
        double total = BASE_COFFEE_PRICE;
        total += toppings.size() * TOPPING_PRICE;
        if (beverageStrategy instanceof SizeDecorator) {
            SizeDecorator sizeDecorator = (SizeDecorator) beverageStrategy;
            total += sizeDecorator.getSizeCostAdjustment();
        }
        return total;
    }

    public String getOrderInfo() {
        if (beverageStrategy == null) {
            return "No coffee selected";
        }
        String coffeeType = beverageStrategy.getClass().getSimpleName()
                .replace("Strategy", "")
                .replace("SizeDecorator", "");
        StringBuilder info = new StringBuilder();
        info.append(String.format("Coffee: %s%n", coffeeType));
        info.append(String.format("Size: %s%n", selectedSize.getDisplayName()));
        info.append(String.format("Toppings: %d%n", toppings.size()));
        info.append(String.format("Total cost: $%.2f", calculateTotalCost()));
        return info.toString();
    }

    private void clearOrder() {
        toppings.clear();
        beverageStrategy = null;
        selectedSize = Size.MEDIUM;
    }

    public Size getSelectedSize() {
        return selectedSize;
    }

    public List<Topping> getToppings() {
        return new LinkedList<>(toppings); // Возвращаем копию
    }

    public boolean hasSelectedCoffee() {
        return beverageStrategy != null;
    }
}
