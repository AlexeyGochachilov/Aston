package third.adapter;

import third.adapter.differentLiquids.*;

import static third.Constants.SEPARATOR;

public class ShowAdapter {

    public static void main(String[] args) {

        BeverageMachine coffeeMachine = new BeverageMachine();

        coffeeMachine.selectBeverage(new LiquidAdapter(new HotWater()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR);

        coffeeMachine.selectBeverage(new LiquidAdapter(new BlackTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR);

        coffeeMachine.selectBeverage(new LiquidAdapter(new GreenTea()));
        coffeeMachine.startPreparingBeverage();

        System.out.println(SEPARATOR);

        coffeeMachine.selectBeverage(new LiquidAdapter(new IcedTea()));
        coffeeMachine.startPreparingBeverage();
    }
}
