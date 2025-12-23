package third.proxy;

import third.builder.Barista;
import third.builder.Coffee;
import third.decorator.Size;
import third.strategy.topping.Milk;

import static third.Constants.SEPARATOR_LINE;

public class TeleportationDemo {

    public static void main(String[] args) {

        Barista barista = new Barista();
        Coffee coffee = barista.makeLatte(Size.MEDIUM, new Milk());
        CoffeeTeleporterProxy proxy = (CoffeeTeleporterProxy)
                TeleporterFactory.createTeleporterProxy();

        System.out.println(SEPARATOR_LINE);

        System.out.println("1. Testing coffee caching in proxy:");
        proxy.setCoffee(coffee);
        for (int i = 1; i <= 3; i++) {
            System.out.printf("\n   Teleportation #%d:%n", i);
            long start = System.currentTimeMillis();
            proxy.teleport();
            long duration = System.currentTimeMillis() - start;
            System.out.printf("   Duration: %dms, State: %s%n", duration, proxy.getState());
        }

        System.out.println(SEPARATOR_LINE);

        System.out.println("\n2. Testing multiple teleporter types:");
        CoffeeTeleportable[] teleporters = {
                TeleporterFactory.createStandardTeleporter(coffee),
                TeleporterFactory.createQuantumTeleporter(coffee),
                proxy
        };
        for (int i = 0; i < teleporters.length; i++) {
            System.out.printf("\n   Teleporter %d (%s):%n",
                    i + 1, teleporters[i].getClass().getSimpleName());
            if (i == 2) {
                System.out.println("   (Already teleported - will be fast)");
            }
            long start = System.currentTimeMillis();
            teleporters[i].teleport();
            long duration = System.currentTimeMillis() - start;
            System.out.printf("   Info: %s%n", teleporters[i].getTeleportationInfo());
            System.out.printf("   Duration: %dms%n", duration);
        }

        System.out.println(SEPARATOR_LINE);

        System.out.println("\n3. Testing error scenarios:");
        try {
            Coffee hotCoffee = Coffee.builder()
                    .withType("Too Hot")
                    .withCoffeeBeans("Arabica")
                    .withSize(Size.MEDIUM)
                    .withTemperature(150)
                    .build();
            RealCoffeeTeleporter invalid = new RealCoffeeTeleporter(
                    hotCoffee, TeleportationLogger.consoleLogger());
            invalid.teleport();
        } catch (Exception e) {
            System.out.println("   ✓ Caught expected error: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
