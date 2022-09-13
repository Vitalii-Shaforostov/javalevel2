package ru.levelup.homework.hw2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareRootApp {

    public static void main(String[] args) throws InterruptedException, IOException {
        int maxNumber = 1_000_000;
        int threadCount = 10;
        String fileName = "./SquareRootResults.csv";
        String fileNameSynchronized = "./SquareRootResultsSynchronized.csv";
        String fileNameSynchronizedList = "./SquareRootResultsSynchronizedList.csv";
        String fileNameNoSynchronization = "./SquareRootResultsNoSynchronization.csv";

        List<Double> results = new ArrayList<>();
        List<Double> resultsSynchronized = new ArrayList<>();
        List<Double> resultsSynchronizedList = Collections.synchronizedList(new ArrayList<>());
        List<Double> resultsNoSynchronization = new ArrayList<>();

        ArrayList<Thread> threads = new ArrayList<>();



        executeOnethreadCalculation(maxNumber, fileName, results);

        executeSynchronizedListCalculation(maxNumber, threadCount, fileNameSynchronized, threads, resultsSynchronizedList);

        executeSynchronizedCalculation(maxNumber, threadCount, fileNameSynchronizedList, threads, resultsSynchronized);

 //       executeNotSynchronizedCalculation(maxNumber, threadCount, fileNameNoSynchronization, resultsNoSynchronization, threads);


    }

    private static void executeNotSynchronizedCalculation(int maxNumber, int threadCount, String fileNameNoSynchronization, List<Double> resultsNoSynchronization, ArrayList<Thread> threads) throws InterruptedException, IOException {
        System.out.println();
        System.out.println("Threads without Synchronization");
        long startTime = System.currentTimeMillis();

        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int finalThreadNumber = threadNumber;
            Thread thread = new Thread(() -> {
                for (int i = 1 + (maxNumber / threadCount * finalThreadNumber ); i <= (maxNumber / threadCount) * (finalThreadNumber+1) ; i++) {
                        resultsNoSynchronization.add(Math.sqrt(i));

                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads){
            thread.join();
        }

        SaveData.writeToFile(fileNameNoSynchronization, resultsNoSynchronization);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");
    }


    private static void executeSynchronizedCalculation(int maxNumber, int threadCount, String fileNameSynchronizedList, ArrayList<Thread> threads, List<Double> resultsSynchronized) throws InterruptedException, IOException {
        System.out.println();
        System.out.println("usage of Synchronized");
        long startTime = System.currentTimeMillis();

        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int finalThreadNumber = threadNumber;
            Thread thread = new Thread(() -> {
                for (int i = 1 + (maxNumber / threadCount * finalThreadNumber ); i <= (maxNumber / threadCount) * (finalThreadNumber+1) ; i++) {
                    synchronized (resultsSynchronized) {
                        resultsSynchronized.add(Math.sqrt(i));
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads){
            thread.join();
        }

        SaveData.writeToFile(fileNameSynchronizedList, resultsSynchronized);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");
    }

    private static void executeSynchronizedListCalculation(int maxNumber, int threadCount, String fileNameSynchronized, ArrayList<Thread> threads, List<Double> resultsSynchronizedList) throws InterruptedException, IOException {
        System.out.println();
        System.out.println("usage of synchronizedList");
        long startTime = System.currentTimeMillis();


        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int finalThreadNumber = threadNumber;
            Thread thread = new Thread(() -> {
                for (int i = 1 + (maxNumber / threadCount * finalThreadNumber ); i <= (maxNumber / threadCount) * (finalThreadNumber+1) ; i++) {
                    resultsSynchronizedList.add(Math.sqrt(i));

                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads){
            thread.join();
        }

        SaveData.writeToFile(fileNameSynchronized, resultsSynchronizedList);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");
    }

    private static void executeOnethreadCalculation(int maxNumber, String fileName, List<Double> results) throws IOException {
        System.out.println();
        System.out.println("1 Thread");

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= maxNumber; i++) {
            results.add(Math.sqrt(i));
                }
        SaveData.writeToFile(fileName, results);

        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) + "ms");
    }
}
