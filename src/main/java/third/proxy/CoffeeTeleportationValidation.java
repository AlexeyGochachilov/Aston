package third.proxy;

import third.builder.Coffee;

public final class CoffeeTeleportationValidation {

    private CoffeeTeleportationValidation() {}

    public static void validateCoffeeForTeleportation(Coffee coffee) {
        if (coffee == null) {
            throw new IllegalArgumentException("Coffee cannot be null for teleportation");
        }
        try {
            coffee.validateForTeleportation();
        } catch (IllegalArgumentException e) {
            throw new IllegalTeleportationException(
                    String.format("Coffee '%s' cannot be teleported: %s",
                            coffee.getType(), e.getMessage()),
                    e
            );
        }
    }

    public static class IllegalTeleportationException extends RuntimeException {
        public IllegalTeleportationException(String message) {
            super(message);
        }

        public IllegalTeleportationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
