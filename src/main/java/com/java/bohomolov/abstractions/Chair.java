package com.java.bohomolov.abstractions;

import com.java.bohomolov.accessories.ChairBack;
import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Style;

import java.util.List;
import java.util.Objects;

public abstract class Chair extends Stool {

    private ChairBack chairBack;


    protected Chair(int height, Style style, ChairSeat chairSeat, List<? extends ChairLeg> legList, ChairBack chairBack) {
        super(height, style, chairSeat, legList);
        this.chairBack = chairBack;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).
        append(chairBack).append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public ChairBack getChairBack() {
        return chairBack;
    }

    public void setChairBack(ChairBack chairBack) {
        this.chairBack = chairBack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chair chair = (Chair) o;
        return getHeight() == chair.getHeight() &&
                getStyle() == chair.getStyle() &&
                Objects.equals(getLegList(), chair.getLegList()) &&
                Objects.equals(getChairSeat(), chair.getChairSeat()) &&
                Objects.equals(getChairBack(), chair.getChairBack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getChairBack());
    }
}
