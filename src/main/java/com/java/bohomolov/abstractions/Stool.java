package com.java.bohomolov.abstractions;

import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Stool {

    private int height;
    private final Style style;
    private List<? extends ChairLeg> legList;
    private ChairSeat chairSeat;

    protected Stool(int height, Style style, ChairSeat chairSeat, List<? extends ChairLeg> legList) {

        this.height = height;
        this.style = style;
        this.legList = new ArrayList<>();
        this.legList = legList;
        this.chairSeat = chairSeat;
    }

    public void setLegs(ChairLeg chairLeg) {
        ChairLeg [] chairLegs = new ChairLeg[4];
        Arrays.fill(chairLegs, chairLeg);
        legList = Arrays.asList(chairLegs);
    }

    public void setChairSeat(ChairSeat chairSeat) {
        this.chairSeat = chairSeat;
    }

    public List<? extends ChairLeg> getLegList() {
        return legList;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Height: ").append(getHeight()).append(System.lineSeparator())
        .append("Designed in ").append(style.getStyle()).append(" style").append(System.lineSeparator())
        .append("With ").append(legList.size()).append(" legs ").append(legList.get(0)).append(System.lineSeparator())
        .append(chairSeat).append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public Style getStyle() {
        return style;
    }

    public ChairSeat getChairSeat() {
        return chairSeat;
    }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public abstract void sit() throws MissingAccessoryException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stool stool = (Stool) o;
        return getHeight() == stool.getHeight() &&
                getStyle() == stool.getStyle() &&
                Objects.equals(getLegList(), stool.getLegList()) &&
                Objects.equals(getChairSeat(), stool.getChairSeat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHeight(), getStyle(), getLegList(), getChairSeat());
    }
}
