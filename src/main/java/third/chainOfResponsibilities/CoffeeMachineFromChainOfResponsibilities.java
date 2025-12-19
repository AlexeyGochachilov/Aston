package third.chainOfResponsibilities;

import third.chainOfResponsibilities.barista.BaristaChain;
import third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static third.Constants.CHAIN_NOT_INITIALIZED;
import static third.Constants.PLEASE_SELECT_COFFEE;
import static third.Constants.PUT_DOWN_CUP;

public class CoffeeMachineFromChainOfResponsibilities {

    private CoffeeType selectedCoffeeType;
    private final List<Topping> toppings;
    private BaristaChain baristaChain;

    public CoffeeMachineFromChainOfResponsibilities() {
        this.toppings = new LinkedList<>();
        this.baristaChain = new BaristaChain();
        System.out.println("CoffeeMachine: Initialized with a barista chain");
    }

     public CoffeeMachineFromChainOfResponsibilities(BaristaChain baristaChain) {
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
