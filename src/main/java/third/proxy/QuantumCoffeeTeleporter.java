package third.proxy;

import third.builder.Coffee;

import static third.Constants.QUANTUM_INITIALIZATION_DELAY_MS;

public class QuantumCoffeeTeleporter extends RealCoffeeTeleporter{

    private int teleportationCount;

    public QuantumCoffeeTeleporter(Coffee coffee, TeleportationLogger logger) {
        super(coffee, logger);
        this.teleportationCount = 0;
        logger.log("Quantum teleporter activated");
    }

    @Override
    public void teleport() {
        teleportationCount++;
        if (teleportationCount == 1) {
            performQuantumInitialization();
        }
        super.teleport();
        if (teleportationCount > 1) {
            logger.log(String.format("Quantum teleportation #%d completed instantly",
                    teleportationCount));
        }
    }

    private void performQuantumInitialization() {
        logger.log("Initializing quantum entanglement...");
        sleepSafely(QUANTUM_INITIALIZATION_DELAY_MS);
        logger.log("Quantum entanglement established");
        sleepSafely(QUANTUM_INITIALIZATION_DELAY_MS);
        logger.log("Teleporting through quantum tunnel...");
    }

    private void sleepSafely(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AbstractCoffeeTeleporter.TeleportationInterruptedException(
                    "Quantum initialization interrupted", e);
        }
    }

    @Override
    public String getTeleportationInfo() {
        return super.getTeleportationInfo() +
                String.format(" | Quantum teleportations: %d", teleportationCount);
    }

    public int getTeleportationCount() {
        return teleportationCount;
    }
}
