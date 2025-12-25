package ru.aston.hometask.fourth;

public class LiveLock {

    private static int counter = 0;
    private static boolean canIncrease = true;
    private static boolean canDecrease = false;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (canIncrease) {
                        counter++;
                        System.out.println(counter);
                        canIncrease = false;
                        canDecrease = true;
                    }
                    if (counter >= 100) {
                        System.out.println("The limit has been reached, resetting counter");
                        counter = 0;
                        canIncrease = true;
                        canDecrease = false;
                    }
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (canDecrease) {
                        counter--;
                        System.out.println(counter);
                        canDecrease = false;
                        canIncrease = true;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
