package ru.aston.hometask.fourth;

public class DeadLock {

    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new DeadThread("Thread1", lock1, lock2));
        Thread t2 = new Thread(new DeadThread("Thread2", lock2, lock1));
        t1.start();
        t2.start();

        try {
            Thread.sleep(10000);
            System.out.println("Program not end, it's DEAD_LOCK!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class DeadThread implements Runnable {
        private final String name;
        private final Object lock1;
        private final Object lock2;

        public DeadThread(String name, Object lock1, Object lock2) {
            this.name = name;
            this.lock1 = lock1;
            this.lock2 = lock2;
        }

        @Override
        public void run() {
            synchronized (lock1) {
                System.out.println(name + ": have monitor " + lock1.toString());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println(name + ": have monitor " + lock2.toString());
                }
            }
        }
    }
}
