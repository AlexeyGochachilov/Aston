package third.adapter.differentLiquids;

public class HotWater implements Beverage {

    @Override
    public void prepareBeverage() {
        System.out.println("Just hot water");
    }
}
