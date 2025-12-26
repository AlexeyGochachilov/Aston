package ru.aston.hometask.fourth;

public class AlternatingNumberPrinter {

    private int number = 1;
    protected final static int FOR_THREAD_ONE = 1;
    protected final static int FOR_THREAD_TWO = 2;

    public synchronized void synchronizedPrintAndSwitch(int expectedNumber) {
        waitForNumberAndPrint(expectedNumber);
        changedNumber();
        notify();
    }

    private void waitForNumberAndPrint(int expectedNumber) {
        while (number != expectedNumber) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted: " + e.getMessage());
                return;
            }
        }
        System.out.println(Thread.currentThread().getName() + " print number " + number);
    }

    private void changedNumber() {
        number = (number == FOR_THREAD_ONE) ? FOR_THREAD_TWO : FOR_THREAD_ONE;
    }

    public static void main(String[] args) {

        AlternatingNumberPrinter numberPrinter = new AlternatingNumberPrinter();
        Thread threadOne = new Thread(new ShowNumber(numberPrinter, AlternatingNumberPrinter.FOR_THREAD_ONE));
        Thread threadTwo = new Thread(new ShowNumber(numberPrinter, AlternatingNumberPrinter.FOR_THREAD_TWO));
        threadOne.start();
        threadTwo.start();
    }
}
