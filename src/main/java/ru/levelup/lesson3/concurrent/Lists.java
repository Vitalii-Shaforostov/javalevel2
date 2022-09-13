package ru.levelup.lesson3.concurrent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lists {
        private static List<String> names = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        for (int threadNumber = 0; threadNumber < 10; threadNumber++) {
            new Thread(() -> {
                for (int i = 0; i < 1000; i++) {
                    synchronized (names) {
                        names.add("name - " + i);
                    }
                }

            }).start();
        }
        Thread.sleep(500);
        System.out.println(names);
    }
}

//example what is array List doing when increment it
class MyArrayList{
    private Object[] items = new Object[10];
    private int count = 0;

    public void add(String name) {
        if (count == items.length) {
            items = Arrays.copyOf(items, count * 2);
        }
            items[count] = name;   //  [name, null , name , name]
            count++;   // 2
        }
    }

