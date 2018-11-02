package ru.otus.l72.behavioral.iterator;

/**
 * Created by tully.
 *
 * Traversal abstraction in the Iterator pattern.
 *
 */
public interface Iterator<T> {
    T next();
    boolean hasNext();
}
