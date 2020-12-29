package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairSeat {

    private final Material chairSeatMaterial;
    private Color chairSeatColor;

    public ChairSeat(Material chairSeatMaterial, Color chairSeatColor) {
        this.chairSeatMaterial = chairSeatMaterial;
        this.chairSeatColor = chairSeatColor;
    }

    public Material getChairSeatMaterial() {
        return chairSeatMaterial;
    }

    public Color getChairSeatColor() {
        return chairSeatColor;
    }

    public void setChairSeatColor(Color chairSeatColor) {
        this.chairSeatColor = chairSeatColor;
    }

    @Override
    public String toString() {
        return "Chair seat made of " + chairSeatColor.getColour() + " color " + chairSeatMaterial.getMaterialName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChairSeat chairSeat = (ChairSeat) o;
        return getChairSeatMaterial() == chairSeat.getChairSeatMaterial() &&
                getChairSeatColor() == chairSeat.getChairSeatColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChairSeatMaterial(), getChairSeatColor());
    }
}
