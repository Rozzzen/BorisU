package com.java.bohomolov;

import com.java.bohomolov.abstractions.Stool;

public class User {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    public void sit(Stool stool) {
        System.out.print(name + " ");
        stool.sit();
    }

    @Override
    public String toString() {
        return name;
    }
}
