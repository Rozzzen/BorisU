package com.java.bohomolov.accessories;

import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;

import java.util.Objects;

public class ChairWheel extends ChairLeg {

    private final Color wheelColor;

    public ChairWheel(Material material, Color color, Color wheelColor) {
        super(material, color);
        this.wheelColor = wheelColor;
    }

    public Color getWheelColor() {
        return wheelColor;
    }

    public String toString() {
        return super.toString() + ". Wheel color is " + wheelColor.getColor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChairWheel that = (ChairWheel) o;
        return getWheelColor() == that.getWheelColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWheelColor());
    }
}
