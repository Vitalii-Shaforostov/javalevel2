package ru.levelup.lesson3.concurrent;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    private static Object lock = new Object();
//    private static long counter = 0;
    private static AtomicLong  counter = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ArrayList<Thread> threads = new ArrayList<>();
        System.out.println("test");

        for (int threadNumber = 0; threadNumber < 20; ++threadNumber) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10_000_000; i++) {
 //                   synchronized (lock){
                    counter.getAndIncrement();
                    counter.getAndAdd(5)   ; //  can increment on any value
//                    }  // counter = counter + 1  // in reality -> long tmp = counter; tmp = tmp+1; counter = tmp
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException ignore) {
//
//                    }
//                    System.out.println("Count " + counter);
                }
            });
            threads.add(thread);
            thread.start();

        }
 //       Thread.sleep(500);
        for (Thread thread : threads){
            thread.join();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Count " + counter);
        System.out.println("Took " + (endTime-startTime) + "ms");
 //       System.out.println("main");
    }
//
//    class Data {
//        private int count;
//        
//        public void increment() {
//            count++;
//        }
//
//        public int getCount{
//            return count;
//        }
//
//    }



}
