package ru.aston.hometask.fourth;

public class Infinity {

    static int number = 1;
    final static int FOR_THREAD_ONE = 1;
    final static int FOR_THREAD_TWO = 2;

    public synchronized void forThreadOne() {
        showNumber(FOR_THREAD_ONE);
        increment();
        notify();
    }

    public synchronized void forThreadTwo() {
        showNumber(FOR_THREAD_TWO);
        decrement();
        notify();
    }

    private void showNumber(int i) {
        while (number != i) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + " print number " + number);
    }

    private void increment () {
        number++;
    }

    private void decrement () {
        number--;
    }

    public static void main(String[] args) {

        Infinity infinity = new Infinity();
        Thread threadOne = new Thread(new ShowNumberOne(infinity));
        Thread threadTwo = new Thread(new ShowNumberTwo(infinity));
        threadOne.setName("Thread 1");
        threadTwo.setName("Thread 2");
        threadOne.start();
        threadTwo.start();
    }

}

class ShowNumberOne implements Runnable {

    Infinity infinity;

    public ShowNumberOne(Infinity infinity) {
        this.infinity = infinity;
    }

    @Override
    public void run() {
        while (true) {
            infinity.forThreadOne();
        }
    }
}

class ShowNumberTwo implements Runnable {

    Infinity infinity;

    public ShowNumberTwo(Infinity infinity) {
        this.infinity = infinity;
    }

    @Override
    public void run() {
        while (true) {
            infinity.forThreadTwo();
        }
    }
}
