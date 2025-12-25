package ru.aston.hometask.fourth;

public class DeadLock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1 have monitor lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Thread1 have monitor lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread2 have monitor lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock1) {
                    System.out.println("Thread2 have monitor lock1");
                }
            }
        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(5000);
            System.out.println("Program not end, it's DEAD_LOCK!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
