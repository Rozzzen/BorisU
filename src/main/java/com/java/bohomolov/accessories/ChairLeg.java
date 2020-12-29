package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairLeg {

    private final Material chairLegMaterial;
    private Color chairLegColor;

    public ChairLeg(Material chairLegMaterial, Color chairLegColor) {
        this.chairLegMaterial = chairLegMaterial;
        this.chairLegColor = chairLegColor;
    }
    public Material getChairLegMaterial() {
        return chairLegMaterial;
    }

    @Override
    public String toString() {
        return "Footing made of " + chairLegColor.getColour() + " color " + chairLegMaterial.getMaterialName();
    }

    public Color getChairLegColor() {
        return chairLegColor;
    }

    public void setChairLegColor(Color chairLegColor) {
        this.chairLegColor = chairLegColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairLeg chairLeg = (ChairLeg) o;
        return getChairLegMaterial() == chairLeg.getChairLegMaterial() &&
                getChairLegColor() == chairLeg.getChairLegColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChairLegMaterial(), getChairLegColor());
    }
}
