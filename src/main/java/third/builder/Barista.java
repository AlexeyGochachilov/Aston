package third.builder;

import third.decorator.Size;
import third.strategy.topping.Topping;

import java.util.Arrays;
import java.util.List;

import static third.Constants.*;

public class Barista {

    public Coffee makeBlackCoffee(Size size, Topping... toppings) {
        return Coffee.builder()
                .withType(CoffeeType.BLACK_COFFEE.getDisplayName())
                .withCoffeeBeans(CoffeeBeansType.ARABICA.getDescription())
                .withSize(size)
                .withTemperature(TEMPERATURE_OF_BLACK_COFFEE)
                .withToppings(Arrays.asList(toppings))
                .build();
    }

    public Coffee makeCappuccino(Size size, Topping... toppings) {
        return Coffee.builder()
                .withType(CoffeeType.CAPPUCCINO.getDisplayName())
                .withCoffeeBeans(CoffeeBeansType.BLEND_ARABICA_ROBUSTA.getDescription())
                .withSize(size)
                .withTemperature(TEMPERATURE_OF_CAPPUCCINO)
                .withToppings(Arrays.asList(toppings))
                .build();
    }

    public Coffee makeLatte(Size size, Topping... toppings) {
        return Coffee.builder()
                .withType(CoffeeType.LATTE.getDisplayName())
                .withCoffeeBeans(CoffeeBeansType.ROBUSTA.getDescription())
                .withSize(size)
                .withTemperature(TEMPERATURE_OF_LATTE)
                .withToppings(Arrays.asList(toppings))
                .build();
    }

    public Coffee makeEspresso(boolean extraShot) {
        return Coffee.builder()
                .withType(CoffeeType.ESPRESSO.getDisplayName())
                .withCoffeeBeans(CoffeeBeansType.ARABICA.getDescription())
                .withSize(Size.SMALL)
                .withTemperature(TEMPERATURE_OF_ESPRESSO)
                .withExtraShot(extraShot)
                .build();
    }

    public Coffee makeCustomCoffee(String type, String beans, Size size,
                                   int temperature, boolean extraShot,
                                   List<Topping> toppings) {
        return Coffee.builder()
                .withType(type)
                .withCoffeeBeans(beans)
                .withSize(size)
                .withTemperature(temperature)
                .withExtraShot(extraShot)
                .withToppings(toppings)
                .build();
    }
}
