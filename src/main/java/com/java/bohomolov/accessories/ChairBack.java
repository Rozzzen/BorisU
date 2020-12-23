package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairBack {

    private final Material material;
    private final Color color;

    public ChairBack(Material material, Color color) {
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
        return "Chair back made of " + color.getColor() + " color " + material.getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairBack chairBack = (ChairBack) o;
        return getMaterial() == chairBack.getMaterial() &&
                getColor() == chairBack.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getColor());
    }
}
