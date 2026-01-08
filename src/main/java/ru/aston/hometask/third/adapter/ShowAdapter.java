package ru.aston.hometask.third.adapter;

import ru.aston.hometask.third.adapter.differentLiquids.BlackTea;
import ru.aston.hometask.third.adapter.differentLiquids.GreenTea;
import ru.aston.hometask.third.adapter.differentLiquids.HotWater;
import ru.aston.hometask.third.adapter.differentLiquids.IcedTea;
import ru.aston.hometask.third.beverageMachines.CoffeeMachine;

import static ru.aston.hometask.third.Constants.SEPARATOR_LINE;

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
