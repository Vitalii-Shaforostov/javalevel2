package ru.levelup.lesson3.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Queue {
    private List<Event> events = Collections.synchronizedList(new ArrayList<>());
    private ArrayBlockingQueue<Event> eventsQueue = new ArrayBlockingQueue<>(100);

    void run() throws InterruptedException {

//        for (Event event : events) {    //  это плохо потому что не удаляется элемент
//            System.out.println(event);
//        }

//        while (true) {
//            Event event = events.remove(0);   // непонятно как подождать новое осбытие, если список пуст
//            System.out.println(event);
//        }

        while (true) {
            Event event = eventsQueue.take();   //  операции уже защищены, если пустая очередь взять не можем,  если переполнена то ждем
            System.out.println(event);          //  Есть ожидания что хорошо. примерно как синхронайзд по времени, может чуть лучше
//        }
        }
    }

    enum Event {
        CREATED,
        DELETED,
        MODIFIED
    }
}
