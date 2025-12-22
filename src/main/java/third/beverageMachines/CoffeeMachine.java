package third.beverageMachines;

import third.decorator.DecoratedCoffeeFactory;
import third.decorator.Size;
import third.decorator.SizeDecorator;
import third.strategy.coffee.CoffeeStrategy;
import third.strategy.topping.Topping;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static third.Constants.*;

public class CoffeeMachine {

    private CoffeeStrategy strategy;
    private final List<Topping> toppings;
    private Size selectedSize;

    public CoffeeMachine() {
        this.toppings = new LinkedList<>();
        this.selectedSize = Size.MEDIUM;
    }

    public void selectBeverage(CoffeeStrategy strategy) {
        this.strategy = strategy;
    }

    public void selectCoffee(CoffeeStrategy coffeeStrategy) {
        this.selectBeverage(coffeeStrategy);
        this.toppings.clear();
    }

    public void selectCoffee(String coffeeType, Size size) {
        this.strategy = DecoratedCoffeeFactory.createCoffee(coffeeType, size);
        this.selectedSize = size;
        this.toppings.clear();
        System.out.printf("Selected %s in %s size%n", coffeeType, size.getDisplayName());
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("Size cannot be null");
        }
        this.selectedSize = size;
        if (this.strategy != null) {
            this.strategy = DecoratedCoffeeFactory.decorateWithSize(this.strategy, size);
            System.out.printf("Size updated to: %s%n", size.getDisplayName());
        }
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
        }
    }

    public void startPreparingBeverage() {
        if (strategyEmpty()){
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        this.strategy.prepare(Collections.emptyList());
    }

    public void startPreparingCoffee() {
        if (strategyEmpty()){
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        List<Topping> toppingsCopy = new LinkedList<>(toppings);
        this.strategy.prepare(toppingsCopy);
        clearOrder();
    }

    private boolean strategyEmpty(){
        boolean empty = false;
        if (this.strategy == null) {
            empty = true;
            System.out.println(PLEASE_SELECT_COFFEE);
        }
        return empty;
    }

    public double calculateTotalCost() {
        if (this.strategy == null) {
            return 0.0;
        }
        double total = BASE_COFFEE_PRICE;
        total += toppings.size() * TOPPING_PRICE;
        if (this.strategy instanceof SizeDecorator) {
            SizeDecorator sizeDecorator = (SizeDecorator) strategy;
            total += sizeDecorator.getSizeCostAdjustment();
        }
        return total;
    }

    public String getOrderInfo() {
        if (this.strategy == null) {
            return "No coffee selected";
        }
        String coffeeType = this.strategy.getClass().getSimpleName()
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
        strategy = null;
        selectedSize = Size.MEDIUM;
    }

    public Size getSelectedSize() {
        return selectedSize;
    }

    public List<Topping> getToppings() {
        return new LinkedList<>(toppings); // Возвращаем копию
    }

    public boolean hasSelectedCoffee() {
        return strategy != null;
    }
}
