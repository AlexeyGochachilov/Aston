package third.chainOfResponsibilities.barista;

import third.chainOfResponsibilities.CoffeeRequest;

public interface Barista {

    boolean handleRequest(CoffeeRequest request);

    void setNextBarista(Barista nextBarista);

    boolean canHandle(CoffeeRequest request);

    String getBaristaName();
}
