package third.proxy;

import third.builder.Coffee;

public class RealCoffeeTeleporter extends AbstractCoffeeTeleporter{

    public RealCoffeeTeleporter(Coffee coffee, TeleportationLogger logger){
        super(coffee, logger);
        logger.log(String.format("Real teleporter created for %s coffee", coffee.getType()));
    }

    @Override
    public void teleport() {
        logger.log("Starting teleportation process...");
        simulateTeleportationDelay();
        logger.log(String.format("Successfully teleported %s coffee", coffee.getType()));
        logger.log(String.format("Details: %s beans, %s size",
                coffee.getCoffeeBeans(), coffee.getSize().getDisplayName()));
        hasBeenTeleported = true;
    }

    @Override
    public String getTeleportationInfo() {
        if (!hasBeenTeleported) {
            return String.format("Coffee '%s' ready for teleportation", coffee.getType());
        }
        return String.format("Coffee '%s' teleported. Size: %s, Beans: %s, Toppings: %d",
                coffee.getType(),
                coffee.getSize().getDisplayName(),
                coffee.getCoffeeBeans(),
                coffee.getToppings().size());
    }
}
