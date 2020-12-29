package com.java.bohomolov.abstractions;

import com.java.bohomolov.accessories.*;
import com.java.bohomolov.enums.Style;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class ChairOnWheels extends Chair {

    private final List<Armrest> armrestList = new ArrayList<>();

    protected ChairOnWheels(int height, Style style, ChairSeat chairSeat,
                            List<ChairWheel> legList, ChairBack chairBack, List<Armrest> armrestList)
    {
        super(height, style, chairSeat, legList, chairBack);
        this.armrestList.addAll(armrestList);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString())
        .append(armrestList.get(0)).append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public List<ChairWheel> getWheelList() {
        List<ChairLeg> chairLegs = super.getLegList();
        List<ChairWheel> chairWheels = new ArrayList<>();
        for(ChairLeg chairLeg : chairLegs) {
            chairWheels.add((ChairWheel) chairLeg);
        }
        return chairWheels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ChairOnWheels that = (ChairOnWheels) o;
        return getHeight() == that.getHeight() &&
                getStyle() == that.getStyle() &&
                Objects.equals(getLegList(), that.getLegList()) &&
                Objects.equals(getChairSeat(), that.getChairSeat()) &&
                Objects.equals(getChairBack(), that.getChairBack()) &&
                Objects.equals(armrestList, that.armrestList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), armrestList);
    }
}
