package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.Chair;
import com.java.bohomolov.accessories.ChairBack;
import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;

import java.util.Arrays;

public class OfficeChair extends Chair {


    public OfficeChair(int height) {
        super(height, Style.MODERN,
                new ChairSeat(Material.CLOTH, Color.BLACK), Arrays.asList(
                new ChairLeg(Material.PLASTIC, Color.BLACK),
                new ChairLeg(Material.PLASTIC, Color.BLACK),
                new ChairLeg(Material.PLASTIC, Color.BLACK),
                new ChairLeg(Material.PLASTIC, Color.BLACK)),
                new ChairBack(Material.CLOTH, Color.BLACK));
    }

    @Override
    public void sit() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Siting on office chair");
    }

}
