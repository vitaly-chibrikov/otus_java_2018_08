package ru.otus.l72.behavioral.observer;

/**
 * Created by tully.
 * <p>
 * Abstract observer in the Observer interface.
 */
@FunctionalInterface
public interface Observer {
    void notify(Event event);
}
