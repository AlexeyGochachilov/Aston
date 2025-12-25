package ru.aston.hometask.third.adapter;

import ru.aston.hometask.third.adapter.differentLiquids.Beverage;
import ru.aston.hometask.third.strategy.coffee.CoffeeStrategy;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.List;

public class LiquidAdapter implements CoffeeStrategy {

    private final Beverage beverage;

    public LiquidAdapter(Beverage beverage) {
        if (beverage == null) {
            throw new IllegalArgumentException("Beverage cannot be null");
        }
        this.beverage = beverage;
    }

    @Override
    public void prepare(List<Topping> toppings) {
        if (toppings != null && !toppings.isEmpty()) {
            System.out.println("Note: Toppings are not supported for this beverage");
        }
        beverage.prepareBeverage();
    }

    public Beverage getAdaptedBeverage() {
        return beverage;
    }
}
