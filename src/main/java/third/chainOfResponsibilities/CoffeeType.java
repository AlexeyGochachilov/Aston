package third.chainOfResponsibilities;

public enum CoffeeType {

    BLACK_COFFEE("Black Coffee"),
    CAPPUCCINO("Cappuccino"),
    LATTE("Latte");

    private final String displayName;

    CoffeeType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static CoffeeType fromString(String type) {
        for (CoffeeType coffeeType : values()) {
            if (coffeeType.name().equalsIgnoreCase(type) ||
                    coffeeType.displayName.equalsIgnoreCase(type)) {
                return coffeeType;
            }
        }
        throw new IllegalArgumentException("Unknown coffee type: " + type);
    }
}
