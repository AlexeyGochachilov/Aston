package third.adapter.differentLiquids;

public class GreenTea extends Tea {

    @Override
    public void prepareBeverage() {
        tea();
        System.out.println("Green Tea");
    }
}
