package third.decorator;

public enum Size {

    SMALL("Small", 0.8, 250),
    MEDIUM("Medium", 1.0, 350),
    LARGE("Large", 1.2, 450),
    EXTRA_LARGE("Extra Large", 1.5, 600);

    private final String displayName;
    private final double costMultiplier;
    private final int capacityMl;

    Size(String displayName, double costMultiplier, int capacityMl) {
        this.displayName = displayName;
        this.costMultiplier = costMultiplier;
        this.capacityMl = capacityMl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getCostMultiplier() {
        return costMultiplier;
    }

    public int getCapacityMl() {
        return capacityMl;
    }

    @Override
    public String toString() {
        return String.format("%s (%d ml)", displayName, capacityMl);
    }
}
