package third.chainOfResponsibilities.barista;

import third.chainOfResponsibilities.CoffeeRequest;

public abstract class AbstractBarista implements Barista {

    protected Barista nextBarista;
    protected final String baristaName;
    protected final int skillLevel;

    protected AbstractBarista(String baristaName, int skillLevel) {
        this.baristaName = baristaName;
        this.skillLevel = skillLevel;
    }

    @Override
    public boolean handleRequest(CoffeeRequest request) {
        System.out.printf("[%s] Request received: %s%n",
                baristaName, request.getCoffeeType().getDisplayName());
        if (canHandle(request)) {
            System.out.printf("[%s] I can cook it! Begin...%n", baristaName);
            prepareCoffee(request);
            logCompletion(request);
            return true;
        }
        if (nextBarista != null) {
            System.out.printf("[%s] I can't cook it. I'm passing it on.%n", baristaName);
            return nextBarista.handleRequest(request);
        }
        System.out.printf("[%s] I can't cook and there's no next barista..%n", baristaName);
        return false;
    }

    @Override
    public void setNextBarista(Barista nextBarista) {
        this.nextBarista = nextBarista;
    }

    @Override
    public String getBaristaName() {
        return baristaName;
    }

    public abstract boolean canHandle(CoffeeRequest request);

    protected abstract void prepareCoffee(CoffeeRequest request);

    protected void logCompletion(CoffeeRequest request) {
        System.out.printf("[%s] Finished cooking %s%n",
                baristaName, request.getCoffeeType().getDisplayName());
    }

    protected boolean isOrderTooComplex(CoffeeRequest request, int maxToppings) {
        return request.getToppings().size() > maxToppings;
    }
}
