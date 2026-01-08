package ru.aston.hometask.fourth;

public class ShowNumber implements Runnable {

    private final AlternatingNumberPrinter numberPrinter;
    private final int targetNumber;

    public ShowNumber(AlternatingNumberPrinter numberPrinter, int targetNumber) {
        this.numberPrinter = numberPrinter;
        this.targetNumber = targetNumber;
    }

    @Override
    public void run() {
        while (true) {
            numberPrinter.synchronizedPrintAndSwitch(targetNumber);
        }
    }
}
