package ru.otus.l72.behavioral.iterator;

/**
 * Created by tully.
 *
 * Abstract Collection in the Iterator pattern.
 */
public interface Iterable<T> {
    Iterator<T> getIterator();
}
