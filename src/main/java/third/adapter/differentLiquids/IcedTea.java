package third.adapter.differentLiquids;

public class IcedTea extends Tea {
    @Override
    public void prepareBeverage() {
        tea();
        System.out.println("Iced Tea");
    }
}
