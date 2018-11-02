package ru.otus.l72.structural.adapter;

/**
 * Created by tully.
 */
public class CartesianPoint implements CartesianPlotter {
    @Override
    public void setPoint(double x, double y) {
        System.out.println("x: " + x + " y: " + y);
    }
}
