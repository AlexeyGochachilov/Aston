package third.chainOfResponsibilities.barista;

import third.chainOfResponsibilities.CoffeeRequest;

import static third.Constants.SEPARATORLINE;

public class BaristaChain {

    private Barista firstBarista;
    private Barista lastBarista;

    public BaristaChain() {
        buildDefaultChain();
    }

    private void buildDefaultChain() {
        JuniorBarista junior = new JuniorBarista();
        MiddleBarista middle = new MiddleBarista();
        SeniorBarista senior = new SeniorBarista();
        junior.setNextBarista(middle);
        middle.setNextBarista(senior);
        this.firstBarista = junior;
        this.lastBarista = senior;
        System.out.println("The barista chain has been created: Junior → Middle → Senior");
    }

    public BaristaChain(Barista... baristas) {
        if (baristas == null || baristas.length == 0) {
            buildDefaultChain();
            return;
        }
        this.firstBarista = baristas[0];
        Barista current = firstBarista;
        for (int i = 1; i < baristas.length; i++) {
            current.setNextBarista(baristas[i]);
            current = baristas[i];
        }
        this.lastBarista = current;
        System.out.printf("A custom chain of %d baristas has been created%n", baristas.length);
    }

    public boolean handleRequest(CoffeeRequest request) {
        System.out.println("\n" + SEPARATORLINE);
        System.out.println("START OF ORDER PROCESSING");
        System.out.println("Order: " + request.getCoffeeType().getDisplayName());
        System.out.println("Toppings: " + request.getToppings().size());
        System.out.println(SEPARATORLINE);
        if (firstBarista == null) {
            System.err.println("ERROR: The barista chain is not initialized!");
            return false;
        }
        boolean handled = firstBarista.handleRequest(request);
        if (handled) {
            System.out.println("✓ The order was successfully completed!");
        } else {
            System.out.println("✗ None of the baristas could fulfill the order.");
        }
        return handled;
    }

    public void addBarista(Barista barista) {
        if (firstBarista == null) {
            firstBarista = barista;
            lastBarista = barista;
        } else {
            lastBarista.setNextBarista(barista);
            lastBarista = barista;
        }
    }

    public void setFirstBarista(Barista barista) {
        if (barista != null) {
            barista.setNextBarista(firstBarista);
            this.firstBarista = barista;
        }
    }

    public Barista getFirstBarista() {
        return firstBarista;
    }

    public Barista getLastBarista() {
        return lastBarista;
    }

    public String getChainInfo() {
        StringBuilder info = new StringBuilder("The Barista Chain: ");
        Barista current = firstBarista;
        while (current != null) {
            info.append(current.getBaristaName());
            current = ((AbstractBarista) current).nextBarista;
            if (current != null) {
                info.append(" → ");
            }
        }
        return info.toString();
    }
}
