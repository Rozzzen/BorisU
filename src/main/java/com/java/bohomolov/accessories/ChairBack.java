package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairBack {

    private final Material chairBackMaterial;
    private final Color chairBackColor;

    public ChairBack(Material chairBackMaterial, Color chairBackColor) {
        this.chairBackMaterial = chairBackMaterial;
        this.chairBackColor = chairBackColor;
    }

    public Material getChairBackMaterial() {
        return chairBackMaterial;
    }

    public Color getChairBackColor() {
        return chairBackColor;
    }

    public String toString() {
        return "Chair back made of " + chairBackColor.getColour() + " color " + chairBackMaterial.getMaterialName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairBack chairBack = (ChairBack) o;
        return getChairBackMaterial() == chairBack.getChairBackMaterial() &&
                getChairBackColor() == chairBack.getChairBackColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChairBackMaterial(), getChairBackColor());
    }
}
