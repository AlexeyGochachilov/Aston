package ru.aston.hometask.third.builder;

import ru.aston.hometask.third.decorator.Size;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.*;

import static ru.aston.hometask.third.Constants.*;
import static ru.aston.hometask.third.builder.CoffeeValidation.validateTemperature;
import static ru.aston.hometask.third.builder.CoffeeValidation.validateToppingsForTeleportation;

public class Coffee {

    private final String type;
    private final String coffeeBeans;
    private final Size size;
    private final List<Topping> toppings;
    private final int temperature;
    private final boolean extraShot;

    private Coffee(Builder builder) {
        this.type = builder.type;
        this.coffeeBeans = builder.coffeeBeans;
        this.size = builder.size;
        this.toppings = Collections.unmodifiableList(new ArrayList<>(builder.toppings));
        this.temperature = builder.temperature;
        this.extraShot = builder.extraShot;
    }

    public String getType() {
        return type;
    }

    public String getCoffeeBeans() {
        return coffeeBeans;
    }

    public Size getSize() {
        return size;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean hasExtraShot() {
        return extraShot;
    }

    public int getCapacityMl() {
        return size.getCapacityMl();
    }

    public boolean isCoffeeBeansBlend() {
        return coffeeBeans != null && coffeeBeans.split(" ").length > 1;
    }

    public void validateForTeleportation() {
        validateTemperature(this.temperature);
        validateToppingsForTeleportation(this.toppings);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String type;
        private String coffeeBeans;
        private Size size;
        private List<Topping> toppings = new ArrayList<>();
        private int temperature = TEMPERATURE_OF_CAPPUCCINO;
        private boolean extraShot = false;

        private Builder() {}

        public Builder withType(String type) {
            this.type = Objects.requireNonNull(type, "Type cannot be null");
            return this;
        }

        public Builder withCoffeeBeans(String coffeeBeans) {
            this.coffeeBeans = Objects.requireNonNull(coffeeBeans, "Coffee beans cannot be null");
            return this;
        }

        public Builder withSize(Size size) {
            this.size = Objects.requireNonNull(size, "Size cannot be null");
            return this;
        }

        public Builder addTopping(Topping topping) {
            this.toppings.add(Objects.requireNonNull(topping, "Topping cannot be null"));
            return this;
        }

        public Builder withToppings(List<Topping> toppings) {
            this.toppings = new ArrayList<>(Objects.requireNonNull(toppings, "Toppings list cannot be null"));
            return this;
        }

        public Builder withTemperature(int temperature) {
            validateTemperature(temperature);
            this.temperature = temperature;
            return this;
        }

        public Builder withExtraShot(boolean extraShot) {
            this.extraShot = extraShot;
            return this;
        }

        public Coffee build() {
            validate();
            return new Coffee(this);
        }

        private void validate() {
            List<String> errors = new ArrayList<>();
            if (type == null || type.trim().isEmpty()) {
                errors.add("Coffee type must be specified");
            }
            if (coffeeBeans == null || coffeeBeans.trim().isEmpty()) {
                errors.add("Coffee beans must be specified");
            }
            if (size == null) {
                errors.add("Size must be specified");
            }
            if (!errors.isEmpty()) {
                throw new IllegalStateException("Invalid coffee configuration: " + String.join(", ", errors));
            }
        }
    }

    @Override
    public String toString() {
        return new CoffeeStringFormatter().format(this);
    }

    private static class CoffeeStringFormatter {

        public String format(Coffee coffee) {
            StringBuilder builder = new StringBuilder();
            builder.append("Coffee: ").append(coffee.getType())
                    .append("\nwith: ").append(formatToppings(coffee.getToppings()))
                    .append("\n[coffeeBeans=").append(coffee.getCoffeeBeans())
                    .append("\ncapacityMl=").append(coffee.getCapacityMl())
                    .append("\ntemperature=").append(coffee.getTemperature()).append("°C")
                    .append("\nextraShot=").append(coffee.hasExtraShot())
                    .append("]");
            return builder.toString();
        }

        private String formatToppings(List<Topping> toppings) {
            if (toppings.isEmpty()) {
                return "no toppings";
            }
            if (toppings.size() == 1) {
                return getToppingName(toppings.get(0));
            }
            List<String> toppingNames = toppings.stream()
                    .map(this::getToppingName)
                    .toList();
            return formatList(toppingNames);
        }

        private String getToppingName(Topping topping) {
            return topping.getClass().getSimpleName();
        }

        private String formatList(List<String> items) {
            if (items.size() == 2) {
                return items.get(0) + " and " + items.get(1);
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < items.size(); i++) {
                if (i == items.size() - 1) {
                    builder.append("and ").append(items.get(i));
                } else {
                    builder.append(items.get(i)).append(", ");
                }
            }
            return builder.toString();
        }
    }
}
