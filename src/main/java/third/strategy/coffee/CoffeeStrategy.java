package third.strategy.coffee;

import third.strategy.topping.Topping;

import java.util.List;

public interface CoffeeStrategy {

    void prepare(List<Topping> toppings);
}
