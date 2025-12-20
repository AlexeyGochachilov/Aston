package third.adapter;

import third.adapter.differentLiquids.*;
import third.beverageMachines.BeverageMachine;

import static third.Constants.SEPARATORLINE;

public class ShowAdapter {

    public static void main(String[] args) {

        BeverageMachine coffeeMachine = new BeverageMachine();

        coffeeMachine.selectBeverage(new LiquidAdapter(new HotWater()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATORLINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new BlackTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATORLINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new GreenTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATORLINE);

        coffeeMachine.selectBeverage(new LiquidAdapter(new IcedTea()));
        coffeeMachine.startPreparingBeverage();
    }
}
