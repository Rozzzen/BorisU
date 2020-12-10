package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.ChairOnWheels;
import com.java.bohomolov.accessories.*;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.interfaces.Rideable;
import com.java.bohomolov.interfaces.Spinable;

import java.util.List;

public class GamerChair extends ChairOnWheels  implements Rideable, Spinable {


    public GamerChair(int height, ChairSeat chairSeat, List<ChairWheel> legList, ChairBack chairBack, List<Armrest> armrestList) {
        super(height, Style.HIGHTEC, chairSeat, legList, chairBack, armrestList);
    }

    @Override
    public void sit() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Sit on gamer chair");
    }

    @Override
    public void ride() {
        if(getLegList().contains(null)) throw new MissingAccessoryException("Missing wheels");
        System.out.println("riding on gamer chair");
    }

    public void tiltBack() {
        if(getChairBack() == null) throw new MissingAccessoryException("Missing back");
        System.out.println("tilted chair back");
    }

    @Override
    public void spin() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Spin on gamer chair");
    }
}
