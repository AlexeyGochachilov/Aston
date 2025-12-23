package third.proxy;

import third.builder.Coffee;

public final class TeleporterProxyState {

    private final Coffee coffee;
    private final boolean realTeleporterInitialized;
    private final boolean firstTeleportationCompleted;

    private TeleporterProxyState(Coffee coffee, boolean realTeleporterInitialized, boolean firstTeleportationCompleted) {
        this.coffee = coffee;
        this.realTeleporterInitialized = realTeleporterInitialized;
        this.firstTeleportationCompleted = firstTeleportationCompleted;
    }

    public static TeleporterProxyState initial() {
        return new TeleporterProxyState(null, false, false);
    }

    public TeleporterProxyState withCoffee(Coffee coffee) {
        return new TeleporterProxyState(coffee, realTeleporterInitialized, firstTeleportationCompleted);
    }

    public TeleporterProxyState withRealTeleporterInitialized() {
        return new TeleporterProxyState(coffee, true, firstTeleportationCompleted);
    }

    public TeleporterProxyState withFirstTeleportationCompleted() {
        return new TeleporterProxyState(coffee, realTeleporterInitialized, true);
    }

    public boolean hasCoffee() {
        return coffee != null;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public boolean isRealTeleporterInitialized() {
        return realTeleporterInitialized;
    }

    public boolean isFirstTeleportationCompleted() {
        return firstTeleportationCompleted;
    }

    @Override
    public String toString() {
        return String.format(
                "TeleporterProxyState[hasCoffee=%s, teleporterInitialized=%s, firstTeleportDone=%s]",
                hasCoffee(), isRealTeleporterInitialized(), isFirstTeleportationCompleted()
        );
    }
}
