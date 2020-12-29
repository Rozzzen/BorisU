package com.java.bohomolov.enums;

public enum Color {

    BLACK ("Black"),
    BROWN ("Brown"),
    WHITE ("White"),
    RED ("Red"),
    CAMOUFLAGE ("Camouflage");

    private final String colour;

    Color(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }

}
