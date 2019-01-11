package ru.otus.l132;

public final class CountedThread extends BaseThread {
    private int i = 0;

    protected void doSomething() {
        super.doSomething();
        i++;
    }

    int getI() {
        return i;
    }
}
