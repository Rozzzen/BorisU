package com.java.bohomolov.enums;

public enum Color {

    BLACK ("Black"),
    BROWN ("Brown"),
    WHITE ("White"),
    RED ("Red"),
    CAMOUFLAGE ("Camouflage");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

//    @Override
//    public String toString() {
//        StringBuilder s = new StringBuilder();
//        for(Color string : Color.values()) s.append(string.getColor()).append(", ");
//        return s.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Color.BLACK);
//    }
}
