package ru.otus.l132;

/**
 * Created by tully.
 */
public class BaseThread extends Thread {

    public void run() {
        while (!CounterSemaphore.instance().stop()) {
            doSomething();
        }
    }

    protected void doSomething() {
       //business logic
    }

}
