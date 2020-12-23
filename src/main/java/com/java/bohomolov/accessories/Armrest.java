package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class Armrest {

    private final Material material;
    private final Color color;

    public Armrest(Material material, Color color) {
        this.material = material;
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return "Armrests made of " + color.getColor() + " color " + material.getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Armrest armrest = (Armrest) o;
        return getMaterial() == armrest.getMaterial() &&
                getColor() == armrest.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getColor());
    }
}
