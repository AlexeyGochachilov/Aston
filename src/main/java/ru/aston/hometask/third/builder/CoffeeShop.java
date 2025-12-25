package ru.aston.hometask.third.builder;

import ru.aston.hometask.third.decorator.Size;
import ru.aston.hometask.third.strategy.topping.Milk;
import ru.aston.hometask.third.strategy.topping.Sugar;
import ru.aston.hometask.third.strategy.topping.Syrup;

import static ru.aston.hometask.third.Constants.SEPARATOR_LINE;

public class CoffeeShop {

    public static void main(String[] args) {

        Barista barista = new Barista();

        System.out.println("=== Welcome to Our Coffee Shop ===");
        System.out.println();

        Coffee cappuccino = barista.makeCappuccino(
                Size.LARGE,
                new Milk(),
                new Sugar()
        );
        System.out.println("Order 1 - Cappuccino:");
        System.out.println(cappuccino);
        System.out.println(SEPARATOR_LINE);

        Coffee blackCoffee = barista.makeBlackCoffee(
                Size.MEDIUM,
                new Syrup()
        );
        System.out.println("Order 2 - Black Coffee:");
        System.out.println(blackCoffee);
        System.out.println(SEPARATOR_LINE);

        Coffee latte = barista.makeLatte(
                Size.EXTRA_LARGE,
                new Milk(),
                new Syrup(),
                new Sugar()
        );
        System.out.println("Order 3 - Latte:");
        System.out.println(latte);
        System.out.println(SEPARATOR_LINE);

        Coffee doubleEspresso = barista.makeEspresso(true);
        System.out.println("Order 4 - Double Espresso:");
        System.out.println(doubleEspresso);
        System.out.println(SEPARATOR_LINE);

        Coffee customCoffee = Coffee.builder()
                .withType("Special Blend")
                .withCoffeeBeans("Ethiopian Yirgacheffe")
                .withSize(Size.MEDIUM)
                .withTemperature(88)
                .withExtraShot(true)
                .addTopping(new Milk())
                .addTopping(new Syrup())
                .build();

        System.out.println("Order 5 - Custom Coffee:");
        System.out.println(customCoffee);
        System.out.println(SEPARATOR_LINE);

        try {
            Coffee invalidCoffee = Coffee.builder()
                    .withType("")
                    .withCoffeeBeans("Arabica")
                    .withSize(Size.MEDIUM)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation Test:");
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}

