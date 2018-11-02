package ru.otus.l72.behavioral.visitor.nopattern;


/**
 * Created by tully.
 */
public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.doRepair();
        car.doWash();
        car.doTO();
    }
}
