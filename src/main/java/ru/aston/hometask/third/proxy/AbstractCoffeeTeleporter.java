package ru.aston.hometask.third.proxy;

import ru.aston.hometask.third.builder.Coffee;

import static ru.aston.hometask.third.Constants.TELEPORTATION_STEPS;
import static ru.aston.hometask.third.Constants.TELEPORTATION_STEP_DELAY_MS;
import static ru.aston.hometask.third.proxy.CoffeeTeleportationValidation.validateCoffeeForTeleportation;

public abstract class AbstractCoffeeTeleporter implements CoffeeTeleportable{

    protected final Coffee coffee;
    protected final TeleportationLogger logger;
    protected boolean hasBeenTeleported;

    public AbstractCoffeeTeleporter(Coffee coffee, TeleportationLogger logger) {
        this.coffee = validateCoffee(coffee);
        this.logger = logger;
        this.hasBeenTeleported = false;
    }

    private Coffee validateCoffee(Coffee coffee) {
        validateCoffeeForTeleportation(coffee);
        return coffee;
    }

    @Override
    public abstract void teleport();

    @Override
    public String getTeleportationInfo() {
        return hasBeenTeleported ?
                String.format("Coffee '%s' teleported successfully", coffee.getType()) :
                "Coffee not yet teleported";
    }

    protected void simulateTeleportationDelay() {
        try {
            for (int i = 1; i <= TELEPORTATION_STEPS; i++) {
                Thread.sleep(TELEPORTATION_STEP_DELAY_MS);
                logger.log(String.format("Teleportation progress: %d/%d",
                        i, TELEPORTATION_STEPS));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TeleportationInterruptedException("Teleportation interrupted", e);
        }
    }

    public boolean hasBeenTeleported() {
        return hasBeenTeleported;
    }

    public static class TeleportationInterruptedException extends RuntimeException {
        public TeleportationInterruptedException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
