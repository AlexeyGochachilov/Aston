package third.chainOfResponsibilities.barista;

import third.chainOfResponsibilities.CoffeeRequest;
import third.chainOfResponsibilities.CoffeeType;
import third.strategy.coffee.BlackCoffeeStrategy;
import third.strategy.coffee.CappuccinoStrategy;
import third.strategy.coffee.CoffeeStrategy;
import third.strategy.coffee.LatteStrategy;
import third.strategy.coffee.CoffeeFactory;

import static third.Constants.SEPARATORLINE;

public class SeniorBarista extends AbstractBarista{

    public SeniorBarista() {
        super("Senior Barista", 3);
    }

    @Override
    public boolean canHandle(CoffeeRequest request) {
        System.out.printf("[%s] Sure, I'll cook it. %s%n",
                baristaName, request.getCoffeeType().getDisplayName());
        return true;
    }

    @Override
    protected void prepareCoffee(CoffeeRequest request) {
        System.out.printf("[%s] Expertly preparing %s with %d topping(s)%n",
                baristaName, request.getCoffeeType().getDisplayName(),
                request.getToppings().size());
        if (!request.getSpecialInstructions().isEmpty()) {
            System.out.printf("[Senior Barista] I take into account special requests: %s%n",
                    request.getSpecialInstructions());
        }
        CoffeeStrategy strategy = createStrategy(request.getCoffeeType());
        prepareExpertEquipment();
        selectPremiumIngredients();
        strategy.prepare(request.getToppings());
        addArtisticDesign();
        performExpertQualityCheck();
        addPersonalizedTouch();
    }

    private CoffeeStrategy createStrategy(CoffeeType type) {
        return switch (type) {
            case BLACK_COFFEE -> new BlackCoffeeStrategy();
            case CAPPUCCINO -> new CappuccinoStrategy();
            case LATTE -> new LatteStrategy();
            default -> CoffeeFactory.createLatte();
        };
    }

    private void prepareExpertEquipment() {
        System.out.println("[Senior Barista] Setting up professional equipment");
    }

    private void selectPremiumIngredients() {
        System.out.println("[Senior Barista] I select premium ingredients");
    }

    private void addArtisticDesign() {
        System.out.println("[Senior Barista] I create an artistic design for coffee");
    }

    private void performExpertQualityCheck() {
        System.out.println("[Senior Barista] I'm conducting a quality assessment... Perfect!");
    }

    private void addPersonalizedTouch() {
        System.out.println("[Senior Barista] Adding a personal touch");
    }

    @Override
    protected void logCompletion(CoffeeRequest request) {
        super.logCompletion(request);
        System.out.println("[Senior Barista] Enjoy the highest quality coffee!");
        System.out.println(SEPARATORLINE);
    }
}
