package ru.aston.hometask.fourth;

import java.util.concurrent.atomic.AtomicBoolean;

public class LiveLock {
    private final AtomicBoolean resource1Busy = new AtomicBoolean(false);
    private final AtomicBoolean resource2Busy = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        LiveLock liveLock = new LiveLock();
        liveLock.runSimulation();
    }

    public void runSimulation() throws InterruptedException {

        Worker worker1 = new Worker("Worker-1", resource1Busy, resource2Busy);
        Worker worker2 = new Worker("Worker-2", resource2Busy, resource1Busy);

        Thread threadOne = new Thread(worker1, "Thred 1");
        Thread threadTwo = new Thread(worker2, "Thred 2");

        System.out.println("Start simulation Livelock ...");

        threadOne.start();
        threadTwo.start();

        Thread.sleep(9000);

        System.out.println("Stop work threads ...");

        worker1.stop();
        worker2.stop();
        threadOne.join();
        threadTwo.join();

        System.out.println("End show LiveLock");
    }

    private static class Worker implements Runnable {

        private final String name;
        private final AtomicBoolean firstResource;
        private final AtomicBoolean secondResource;
        private volatile boolean running = true;

        public Worker(String name, AtomicBoolean firstResource,
                      AtomicBoolean secondResource) {
            this.name = name;
            this.firstResource = firstResource;
            this.secondResource = secondResource;
        }

        public void stop() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                try {
                    attemptWork();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println(name + " was interrupt");
                    break;
                }
            }
            System.out.println(name + " finished work");
        }

        private void attemptWork() throws InterruptedException {
            if (firstResource.compareAndSet(false, true)) {
                System.out.println(name + ": catch first resource");
                try {
                    Thread.sleep(1000);
                    if (secondResource.compareAndSet(false, true)) {
                        System.out.println(name + ": catch second resource and do work");
                        Thread.sleep(1000);
                        System.out.println(name + ": finished work");
                        secondResource.set(false);
                    } else {
                        System.out.println(name + ": second resource is buse, leave first");
                    }
                } finally {
                    firstResource.set(false);
                }
            }
        }
    }
}