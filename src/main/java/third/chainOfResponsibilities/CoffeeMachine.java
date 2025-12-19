package third.chainOfResponsibilities;

import third.chainOfResponsibilities.barista.BaristaChain;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

public class CoffeeMachine {

    private CoffeeType selectedCoffeeType;
    private final List<Topping> toppings;
    private BaristaChain baristaChain;

    private static final String PLEASE_SELECT_COFFEE = "Please firstly select a coffee";
    private static final String PUT_DOWN_CUP = "put down a paper cup";
    private static final String CHAIN_NOT_INITIALIZED = "Barista chain is not initialized";

    public CoffeeMachine() {
        this.toppings = new LinkedList<>();
        this.baristaChain = new BaristaChain();
        System.out.println("CoffeeMachine: Initialized with a barista chain");
    }

     public CoffeeMachine(BaristaChain baristaChain) {
        this.toppings = new LinkedList<>();
        this.baristaChain = baristaChain;
        System.out.println("CoffeeMachine: Initialized with a custom chain");
    }

    public void selectCoffee(CoffeeType coffeeType) {
        if (coffeeType == null) {
            throw new IllegalArgumentException("Coffee type cannot be null");
        }
        this.selectedCoffeeType = coffeeType;
        this.toppings.clear();
        System.out.printf("Select Coffee: %s%n", coffeeType.getDisplayName());
    }

    public void addTopping(Topping topping) {
        if (topping != null) {
            toppings.add(topping);
            System.out.printf("Add topping: %s%n",
                    topping.getClass().getSimpleName());
        }
    }

    public void startPreparingCoffee() {
        if (selectedCoffeeType == null) {
            System.out.println(PLEASE_SELECT_COFFEE);
            return;
        }
        if (baristaChain == null) {
            System.out.println(CHAIN_NOT_INITIALIZED);
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        CoffeeRequest request = new CoffeeRequest(selectedCoffeeType, toppings);
        boolean success = baristaChain.handleRequest(request);
        if (success) {
            toppings.clear();
            selectedCoffeeType = null;
        }
    }

    public void setBaristaChain(BaristaChain baristaChain) {
        this.baristaChain = baristaChain;
        System.out.println("A new barista chain has been installed");
    }

    public BaristaChain getBaristaChain() {
        return baristaChain;
    }

    public String getOrderInfo() {
        if (selectedCoffeeType == null) {
            return "No coffee selected";
        }

        return String.format("Coffee: %s, Toppings: %d",
                selectedCoffeeType.getDisplayName(), toppings.size());
    }
}
