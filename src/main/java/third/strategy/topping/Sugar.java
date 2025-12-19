package third.strategy.topping;

public class Sugar implements Topping{

    @Override
    public void addTopping() {
        System.out.println("Add Sugar");
    }
}
