package com.java.bohomolov.enums;

public enum Material {

    WOOD ("Wood"),
    LEATHER ("Leather"),
    STEEL ("Steel"),
    PLASTIC("Plastic"),
    CLOTH ("Cloth");

    private final String material;

    Material(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}
