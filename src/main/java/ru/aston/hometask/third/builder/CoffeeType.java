package ru.aston.hometask.third.builder;

public enum CoffeeType {

    BLACK_COFFEE("Black Coffee"),
    CAPPUCCINO("Cappuccino"),
    LATTE("Latte"),
    ESPRESSO("Espresso"),
    AMERICANO("Americano");

    private final String displayName;

    CoffeeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
