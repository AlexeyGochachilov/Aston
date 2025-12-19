package third.strategy.coffee;

public class BlackCoffeeStrategy extends BaseCoffeeStrategy {

    @Override
    protected void brewCoffee() {
        System.out.println("Preparing Black Coffee");
    }
}
