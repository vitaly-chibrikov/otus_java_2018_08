package ru.otus.l132;

/**
 * @author v.chibrikov
 */
public class StateObject {
    private int i;

    public synchronized void increment() {
            i++;
    }

    public synchronized int getI() {
        return i;
    }
}
