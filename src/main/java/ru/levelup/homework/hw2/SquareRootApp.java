package ru.levelup.homework.hw2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquareRootApp {

    public static void main(String[] args) throws InterruptedException, IOException {
        int maxDigit = 30_000;
        int threadCount = 20;
        String fileName = "./SquareRootResults.csv";
        String fileNameSynchronized = "./SquareRootResultsSynchronized.csv";
        String fileNameSynchronizedList = "./SquareRootResultsSynchronizedList.csv";

        List<Double> results = new ArrayList<>();
        List<Double> resultsSynchronized = new ArrayList<>();
        List<Double> resultsSynchronizedList = Collections.synchronizedList(new ArrayList<>());

        ArrayList<Thread> threads = new ArrayList<>();



        executeOnethreadCalculation(maxDigit, fileName, results);

        executeSynchronizedListCalculation(maxDigit, threadCount, fileNameSynchronized, threads, resultsSynchronizedList);

        executeSynchronizedCalculation(maxDigit, threadCount, fileNameSynchronizedList, threads, resultsSynchronized);

    }




    private static void executeSynchronizedCalculation(int maxDigit, int threadCount, String fileNameSynchronizedList, ArrayList<Thread> threads, List<Double> resultsSynchronized) throws InterruptedException, IOException {
        System.out.println();
        System.out.println("usage of Synchronized");
        long startTime3 = System.currentTimeMillis();

        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int finalThreadNumber = threadNumber;
            Thread thread = new Thread(() -> {
                for (int i = 1 + (maxDigit / threadCount * finalThreadNumber ); i <= (maxDigit / threadCount) * (finalThreadNumber+1) ; i++) {
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

        long endTime3 = System.currentTimeMillis();
        System.out.println("Took " + (endTime3 - startTime3) + "ms");
    }

    private static void executeSynchronizedListCalculation(int maxDigit, int threadCount, String fileNameSynchronized, ArrayList<Thread> threads, List<Double> resultsSynchronizedList) throws InterruptedException, IOException {
        System.out.println();
        System.out.println("usage of synchronizedList");
        long startTime2 = System.currentTimeMillis();


        for (int threadNumber = 0; threadNumber < threadCount; threadNumber++) {
            int finalThreadNumber = threadNumber;
            Thread thread = new Thread(() -> {
                for (int i = 1 + (maxDigit / threadCount * finalThreadNumber ); i <= (maxDigit / threadCount) * (finalThreadNumber+1) ; i++) {
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

        long endTime2 = System.currentTimeMillis();
        System.out.println("Took " + (endTime2 - startTime2) + "ms");
    }

    private static void executeOnethreadCalculation(int maxDigit, String fileName, List<Double> results) throws IOException {
        System.out.println();
        System.out.println("1 Thread");

        long startTime1 = System.currentTimeMillis();

        for (int i = 1; i <= maxDigit; i++) {
            results.add(Math.sqrt(i));
                }
        SaveData.writeToFile(fileName, results);

        long endTime1 = System.currentTimeMillis();
        System.out.println("Took " + (endTime1 - startTime1) + "ms");
    }
}
