package ru.aston.hometask.fourth;

public class LiveLock {
    static boolean resource1Busy = false;
    static boolean resource2Busy = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (!resource1Busy) {
                    resource1Busy = true;
                    System.out.println("Thread 1: Captured resource1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    if (!resource2Busy) {
                        resource2Busy = true;
                        System.out.println("Thread 1: Captured resource2 and working");
                        resource2Busy = false;
                    }
                    resource1Busy = false;
                    System.out.println("Thread 1: Released resource1");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                if (!resource2Busy) {
                    resource2Busy = true;
                    System.out.println("Thread 2: Captured resource2");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    if (!resource1Busy) {
                        resource1Busy = true;
                        System.out.println("Thread 2: Captured resource1 and working");
                        resource1Busy = false;
                    }
                    resource2Busy = false;
                    System.out.println("Thread 2: Released resource2");
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        });

        t1.start();
        t2.start();
    }
}