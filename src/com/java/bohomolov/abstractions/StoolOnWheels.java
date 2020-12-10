package com.java.bohomolov.abstractions;

import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.enums.Style;

import java.util.List;

public abstract class StoolOnWheels extends Stool {


    protected StoolOnWheels(int height, Style style, ChairSeat chairSeat, List<ChairWheel> legList) {
        super(height, style, chairSeat, legList);
    }

    public String toString() {
        return super.toString();
    }

    public List<ChairWheel> getLegList() {
        return (List<ChairWheel>) super.getLegList();
    }
}
