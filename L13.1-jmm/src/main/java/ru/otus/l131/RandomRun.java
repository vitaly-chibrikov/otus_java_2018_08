package ru.otus.l131;

class RandomRun {

    private static final int MAX_THREADS_COUNT = 20;

    void start() {
        for (int i = 0; i < MAX_THREADS_COUNT; ++i) {
            new Thread(() -> System.out.println(
                    Thread.currentThread().getName())
            ).start();
        }
    }
}
