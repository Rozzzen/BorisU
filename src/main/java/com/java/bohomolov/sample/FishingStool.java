package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.Stool;
import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.interfaces.Foldable;

import java.util.Arrays;

public class FishingStool extends Stool implements Foldable {

    private boolean isFolded;

    public FishingStool(int height) {
        super(height, Style.CLASSIC, new ChairSeat(Material.CLOTH, Color.CAMOUFLAGE), Arrays.asList(
                new ChairLeg(Material.STEEL, Color.WHITE),
                new ChairLeg(Material.STEEL, Color.WHITE))
        );
    }

    public boolean isFolded() {return isFolded;}

    @Override
    public void fold() {
        isFolded = true;
    }

    @Override
    public void unfold() {
        isFolded = false;
    }

    @Override
    public void sit() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        System.out.println("Siting on fishing stool");
    }
}
