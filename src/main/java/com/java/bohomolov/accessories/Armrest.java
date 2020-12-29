package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class Armrest {

    private final Material armrestMaterial;
    private final Color armrestColor;

    public Armrest(Material armrestMaterial, Color armrestColor) {
        this.armrestMaterial = armrestMaterial;
        this.armrestColor = armrestColor;
    }

    public Material getArmrestMaterial() {
        return armrestMaterial;
    }

    public Color getArmrestColor() {
        return armrestColor;
    }

    public String toString() {
        return "Armrests made of " + armrestColor.getColour() + " color " + armrestMaterial.getMaterialName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armrest armrest = (Armrest) o;
        return getArmrestMaterial() == armrest.getArmrestMaterial() &&
                getArmrestColor() == armrest.getArmrestColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArmrestMaterial(), getArmrestColor());
    }
}
