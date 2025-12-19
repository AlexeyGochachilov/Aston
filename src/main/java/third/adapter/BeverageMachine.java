package third.adapter;

import third.strategy.coffee.CoffeeStrategy;

import java.util.Collections;

import static third.Constants.PLEASE_SELECT_BEVERAGE;
import static third.Constants.PUT_DOWN_CUP;

public class BeverageMachine {

    private CoffeeStrategy beverageStrategy;

    public void selectBeverage(CoffeeStrategy strategy) {
        beverageStrategy = strategy;
    }

    public void startPreparingBeverage() {
        if (beverageStrategy == null) {
            System.out.println(PLEASE_SELECT_BEVERAGE);
            return;
        }
        System.out.println(PUT_DOWN_CUP);
        beverageStrategy.prepare(Collections.emptyList());
    }
}
