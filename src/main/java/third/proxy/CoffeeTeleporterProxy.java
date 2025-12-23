package third.proxy;

import third.builder.Coffee;

public final class CoffeeTeleporterProxy implements CoffeeTeleportable {

    private TeleporterProxyState state;
    private RealCoffeeTeleporter realTeleporter;
    private final TeleportationLogger logger;

    public CoffeeTeleporterProxy(TeleportationLogger logger) {
        this.state = TeleporterProxyState.initial();
        this.logger = logger;
        logger.log("Coffee teleporter proxy initialized");
    }

    public CoffeeTeleporterProxy() {
        this(TeleportationLogger.consoleLogger());
    }

    public void setCoffee(Coffee coffee) {
        if (state.hasCoffee()) {
            logger.log("Warning: Coffee already set. Only the first coffee will be teleported");
            return;
        }
        state = state.withCoffee(coffee);
        logger.log(String.format("Coffee set for teleportation: %s", coffee.getType()));
    }

    @Override
    public void teleport() {
        validateCoffeeIsSet();
        if (state.isFirstTeleportationCompleted()){
            performSubsequentTeleportation();
        } else {
            performFirstTeleportation();
        }
    }

    private void validateCoffeeIsSet() {
        if (!state.hasCoffee()) {
            String message = "Cannot teleport: coffee not set. Call setCoffee() first";
            logger.log(message);
            throw new IllegalStateException(message);
        }
    }

    private void performFirstTeleportation() {
        logger.log("First teleportation: initializing real teleporter...");
        initializeRealTeleporter();
        realTeleporter.teleport();
        state = state.withRealTeleporterInitialized()
                .withFirstTeleportationCompleted();
        logger.log("First teleportation completed. Future teleportations will be instant");
    }

    private void performSubsequentTeleportation() {
        logger.log("Fast teleportation: returning cached coffee");
        logger.log(realTeleporter.getTeleportationInfo());
    }

    private void initializeRealTeleporter() {
        realTeleporter = new RealCoffeeTeleporter(state.getCoffee(), logger);
        state = state.withRealTeleporterInitialized();
    }

    @Override
    public String getTeleportationInfo() {
        if (realTeleporter != null) {
            return "Proxy: " + realTeleporter.getTeleportationInfo();
        }
        if (state.hasCoffee()) {
            return String.format("Proxy: Coffee '%s' set but not teleported yet",
                    state.getCoffee().getType());
        }
        return "Proxy: No coffee set for teleportation";
    }

    public TeleporterProxyState getState() {
        return state;
    }
}
