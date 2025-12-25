package ru.aston.hometask.third.beverageMachines;

import ru.aston.hometask.third.chainOfResponsibilities.CoffeeRequest;
import ru.aston.hometask.third.chainOfResponsibilities.CoffeeType;
import ru.aston.hometask.third.chainOfResponsibilities.barista.BaristaChain;
import ru.aston.hometask.third.strategy.topping.Topping;

import java.util.LinkedList;
import java.util.List;

import static ru.aston.hometask.third.Constants.CHAIN_NOT_INITIALIZED;
import static ru.aston.hometask.third.Constants.PLEASE_SELECT_COFFEE;
import static ru.aston.hometask.third.Constants.PUT_DOWN_CUP;

public class CoffeeMachineForBarista extends CoffeeMachine {

    private CoffeeType selectedCoffeeType;
    private BaristaChain baristaChain;
    private List<Topping> toppings;

    public CoffeeMachineForBarista() {
        this.toppings = new LinkedList<>();
        this.baristaChain = new BaristaChain();
        System.out.println("CoffeeMachine: Initialized with a barista chain");
    }

     public CoffeeMachineForBarista(BaristaChain baristaChain) {
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
        showInfoInRecipe(selectedCoffeeType, toppings);
        System.out.println(PUT_DOWN_CUP);
        CoffeeRequest request = new CoffeeRequest(selectedCoffeeType, toppings);
        boolean success = baristaChain.handleRequest(request);
        if (success) {
            toppings.clear();
            selectedCoffeeType = null;
        }
    }

    private void showInfoInRecipe(CoffeeType coffeeType, List<Topping> toppings) {
        System.out.printf("%nSelect Coffee: %s%n", coffeeType.getDisplayName());
        toppings.forEach(topping ->
                System.out.printf("Select topping: %s%n", topping.getClass().getSimpleName()));

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
        return String.format("Coffee: %s, Toppings: %d", selectedCoffeeType.getDisplayName(), toppings.size());
    }
}
