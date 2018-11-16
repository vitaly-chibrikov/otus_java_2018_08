package ru.otus.l921.main;

public class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "Nobody";
        this.age = 0;
    }

    public String toString() {
        return "Name: " + name + " age: " + age;
    }
}
