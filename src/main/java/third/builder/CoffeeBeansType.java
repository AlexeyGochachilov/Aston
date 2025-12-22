package third.builder;

public enum CoffeeBeansType {

    ARABICA("Arabica"),
    ROBUSTA("Robusta"),
    LIBERICA("Liberica"),
    BLEND_ARABICA_ROBUSTA("Arabica and Robusta blend");

    private final String description;

    CoffeeBeansType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBlend() {
        return this == BLEND_ARABICA_ROBUSTA;
    }
}
