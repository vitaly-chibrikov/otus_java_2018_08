package ru.otus.l152.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by tully.
 */
public class CallCounterSynchronized implements CallCounter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
