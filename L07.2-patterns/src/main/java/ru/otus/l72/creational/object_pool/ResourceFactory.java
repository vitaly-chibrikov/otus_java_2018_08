package ru.otus.l72.creational.object_pool;

/**
 * Created by tully.
 */
@FunctionalInterface
public interface ResourceFactory {
    Resource get();
}
