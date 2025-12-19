package third.chainOfResponsibilities.barista;

import third.chainOfResponsibilities.CoffeeRequest;
import third.chainOfResponsibilities.CoffeeType;
import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CoffeeStrategy;

public class JuniorBarista extends AbstractBarista {

    private static final int MAX_TOPPINGS_FOR_JUNIOR = 2;

    public JuniorBarista() {
        super("Junior Barista", 1);
    }

    @Override
    public boolean canHandle(CoffeeRequest request) {
        if (request.getCoffeeType() != CoffeeType.BLACK_COFFEE) {
            return false;
        }
        if (isOrderTooComplex(request, MAX_TOPPINGS_FOR_JUNIOR)) {
            System.out.printf("[%s] Too many toppings (%d). Maximum for June: %d%n",
                    baristaName, request.getToppings().size(), MAX_TOPPINGS_FOR_JUNIOR);
            return false;
        }
        return true;
    }

    @Override
    protected void prepareCoffee(CoffeeRequest request) {
        System.out.printf("[%s] I prepare black coffee with %d topping(s)%n",
                baristaName, request.getToppings().size());
        CoffeeStrategy strategy = new BlackCoffeeStrategy();
        System.out.println("[Junior Barista] Preparation...");
        strategy.prepare(request.getToppings());
        performBasicQualityCheck();
    }

    private void performBasicQualityCheck() {
        System.out.println("[Junior Barista] Checking the basic quality... OK");
    }

    @Override
    protected void logCompletion(CoffeeRequest request) {
        super.logCompletion(request);
        System.out.println("[Junior Barista] Ready! I hope you enjoy the coffee!");
    }
}
