package third.adapter;

import third.adapter.differentLiquids.*;
import third.beverageMachines.CoffeeMachine;

import static third.Constants.SEPARATOR_LINE;

public class ShowAdapter {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();

        coffeeMachine.selectBeverage(new LiquidAdapter(new HotWater()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new BlackTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new GreenTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR_LINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new IcedTea()));
        coffeeMachine.startPreparingBeverage();
    }
}
