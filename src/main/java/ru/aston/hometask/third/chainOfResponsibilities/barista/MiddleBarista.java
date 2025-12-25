package ru.aston.hometask.third.chainOfResponsibilities.barista;

import ru.aston.hometask.third.chainOfResponsibilities.CoffeeRequest;
import ru.aston.hometask.third.chainOfResponsibilities.CoffeeType;
import ru.aston.hometask.third.strategy.coffee.BlackCoffeeStrategy;
import ru.aston.hometask.third.strategy.coffee.CappuccinoStrategy;
import ru.aston.hometask.third.strategy.coffee.CoffeeStrategy;

public class MiddleBarista extends AbstractBarista {

    private static final int MAX_TOPPINGS_FOR_MIDDLE = 3;

    public MiddleBarista() {
        super("Middle Barista", 2);
    }

    @Override
    public boolean canHandle(CoffeeRequest request) {
        CoffeeType type = request.getCoffeeType();
        if (type != CoffeeType.BLACK_COFFEE && type != CoffeeType.CAPPUCCINO) {
            return false;
        }
        if (isOrderTooComplex(request, MAX_TOPPINGS_FOR_MIDDLE)) {
            System.out.printf("[%s] The order is too complicated. I'm passing it on to the senior.%n", baristaName);
            return false;
        }
        return true;
    }

    @Override
    protected void prepareCoffee(CoffeeRequest request) {
        System.out.printf("[%s] I cook %s professionally%n",
                baristaName, request.getCoffeeType().getDisplayName());
        CoffeeStrategy strategy = createStrategyForType(request.getCoffeeType());
        prepareEquipment();
        strategy.prepare(request.getToppings());
        addProfessionalTouch();
        performQualityCheck();
    }

    private CoffeeStrategy createStrategyForType(CoffeeType type) {
        return switch (type) {
            case BLACK_COFFEE -> new BlackCoffeeStrategy();
            case CAPPUCCINO -> new CappuccinoStrategy();
            default -> throw new IllegalArgumentException("Unsupported coffee type: " + type);
        };
    }

    private void prepareEquipment() {
        System.out.println("[Middle Barista] I prepare professional equipment");
    }

    private void addProfessionalTouch() {
        System.out.println("[Middle Barista] Adding a professional touch");
    }

    private void performQualityCheck() {
        System.out.println("[Middle Barista] I check the quality... Great!");
    }

    @Override
    protected void logCompletion(CoffeeRequest request) {
        super.logCompletion(request);
        System.out.println("[Middle Barista] Enjoy your coffee!");
    }
}
