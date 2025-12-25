package ru.aston.hometask.third.builder;

import ru.aston.hometask.third.decorator.Size;

import java.util.Collection;

import static ru.aston.hometask.third.Constants.*;

public final class CoffeeValidation {

    private CoffeeValidation() {
    }

    public static void validateTemperature(int temperature) {
        if (temperature < MIN_TEMPERATURE) {
            throw new IllegalArgumentException(String.format("Temperature cannot be below %d°C", MIN_TEMPERATURE));
        }
        if (temperature > MAX_TEMPERATURE) {
            throw new IllegalArgumentException(String.format("Temperature cannot exceed %d°C", MAX_TEMPERATURE));
        }
    }

    public static <T> void validateToppingsForTeleportation(Collection<T> toppings){
        if (toppings == null) {
            return;
        }
        if (toppings.size() > MAX_TOPPINGS_FOR_TELEPORTATION) {
            throw  new IllegalArgumentException(
                    String.format("Cannot teleport coffee with more than %d toppings\", \n" +
                             MAX_TOPPINGS_FOR_TELEPORTATION)
            );
        }
    }

    public static void validateRequiredFields(String type, String beans, Size size) {
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Coffee type cannot be null or empty");
        }
        if (beans == null || beans.trim().isEmpty()) {
            throw new IllegalArgumentException("Coffee beans cannot be null or empty");
        }
        if (size == null) {
            throw new IllegalArgumentException("Coffee size cannot be null");
        }
    }
}
