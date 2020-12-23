package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.Stool;
import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.interfaces.Riseable;
import com.java.bohomolov.interfaces.Spinable;

import java.util.Arrays;

public class BarStool extends Stool implements Riseable, Spinable {


    public BarStool(int height) {
        super(height, Style.MODERN, new ChairSeat(Material.WOOD, Color.RED), Arrays.asList(
                new ChairLeg(Material.STEEL, Color.WHITE))
        );
    }

    @Override
    public void riseChair() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Rised chair");
        setHeight(getHeight() + 25);
    }

    @Override
    public void lowerChair() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Lowered chair");
        setHeight(getHeight() - 25);
    }

    @Override
    public void sit() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Siting on bar stool");
    }

    @Override
    public void spin() {
        if(getLegList().contains(null)) throw new MissingAccessoryException("Missing footing");
        System.out.println("Bar stool spins");
    }


}
