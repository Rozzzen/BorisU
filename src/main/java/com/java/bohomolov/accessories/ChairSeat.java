package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairSeat {

    private final Material material;
    private Color color;

    public ChairSeat(Material material, Color color) {
        this.material = material;
        this.color = color;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Chair seat made of " + color.getColor() + " color " + material.getMaterial();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairSeat chairSeat = (ChairSeat) o;
        return getMaterial() == chairSeat.getMaterial() &&
                getColor() == chairSeat.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMaterial(), getColor());
    }
}
