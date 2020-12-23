package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairLeg {

    private final Material material;
    private Color color;

    public ChairLeg(Material material, Color color) {
        this.material = material;
        this.color = color;
    }
    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Footing made of " + color.getColor() + " color " + material.getMaterial();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairLeg chairLeg = (ChairLeg) o;
        return getMaterial() == chairLeg.getMaterial() &&
                getColor() == chairLeg.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getColor());
    }
}
