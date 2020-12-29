package com.java.bohomolov.enums;

public enum Material {

    WOOD ("Wood"),
    LEATHER ("Leather"),
    STEEL ("Steel"),
    PLASTIC("Plastic"),
    CLOTH ("Cloth");

    private final String materialName;

    Material(String materialName) {
        this.materialName = materialName;
    }

    public String getMaterialName() {
        return materialName;
    }
}
