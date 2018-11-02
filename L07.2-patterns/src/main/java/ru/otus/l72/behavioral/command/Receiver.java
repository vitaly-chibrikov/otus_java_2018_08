package ru.otus.l72.behavioral.command;

/**
 * Created by tully.
 * <p>
 * Receiver of the Command pattern.
 */
public class Receiver {
    /**
     * action() method in Command pattern
     *
     * @param msg message to print
     */
    public void action(String msg) {
        System.out.println(msg);
    }
}
