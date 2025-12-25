package ru.aston.hometask.fourth;

public class Infinity {

    static int number = 1;

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

    public synchronized void showNumberOne() {
        showNumber(1);
        number++;
        notify();
    }

    public synchronized void showNumberTwo() {
        showNumber(2);
        number--;
        notify();
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
            infinity.showNumberOne();
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
            infinity.showNumberTwo();
        }
    }
}
