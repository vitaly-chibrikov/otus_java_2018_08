package ru.otus.l72.behavioral.template_method;

/**
 * Created by tully.
 */
public class Minus extends Operation {

    @Override
    protected int apply(int a, int b) {
        return a - b;
    }
}
