package ru.aston.hometask.fourth;

public class ShowNumber implements Runnable {

    AlternatingNumberPrinter numberPrinter;
    int targetNumber;

    public ShowNumber(AlternatingNumberPrinter numberPrinter, int targetNumber) {
        this.numberPrinter = numberPrinter;
        this.targetNumber = targetNumber;
    }

    private void setThreadName() {
        String threadName =
                (targetNumber == AlternatingNumberPrinter.FOR_THREAD_ONE)
                        ? "Thread 1" : "Thread 2";
        Thread.currentThread().setName(threadName);
    }

    @Override
    public void run() {
        setThreadName();
        while (true) {
            numberPrinter.synchronizedPrintAndSwitch(targetNumber);
        }
    }
}
