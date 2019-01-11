package ru.otus.l132;

/**
 * Steps of the solution.
 * <p>
 * 1. static
 * 2. volatile
 * 3. synchronized
 * 4. synchronized(object)
 * 5. synchronized(class)
 * 6. synchronized StateObject
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {
        new InterferenceExample().start();
    }
}
