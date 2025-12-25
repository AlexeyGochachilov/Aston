package ru.aston.hometask.third.proxy;

import ru.aston.hometask.third.builder.Coffee;

public final class TeleporterFactory {

    private TeleporterFactory() {}

    public static CoffeeTeleportable createStandardTeleporter(Coffee coffee) {
        return new RealCoffeeTeleporter(coffee, TeleportationLogger.consoleLogger());
    }

    public static CoffeeTeleportable createQuantumTeleporter(Coffee coffee) {
        return new QuantumCoffeeTeleporter(coffee, TeleportationLogger.consoleLogger());
    }

    public static CoffeeTeleportable createTeleporterProxy() {
        return new CoffeeTeleporterProxy(TeleportationLogger.consoleLogger());
    }

    public static CoffeeTeleportable createTeleporterWithLogger(Coffee coffee,  TeleportationLogger logger) {
        return new RealCoffeeTeleporter(coffee, logger);
    }

    public static CoffeeTeleportable createTeleporterProxy(TeleportationLogger logger) {
        return new CoffeeTeleporterProxy(logger);
    }
}
