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
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarStool extends Stool implements Riseable, Spinable {

    private static final Logger LOGGER = Logger.getGlobal();
    private static final String EXCEPTION_MESSAGE = "Missing seat";

    public BarStool(int height) {
        super(height, Style.MODERN, new ChairSeat(Material.WOOD, Color.RED), Arrays.asList(
                new ChairLeg(Material.STEEL, Color.WHITE))
        );
    }

    @Override
    public void riseChair() {
        if(getChairSeat() == null) throw new MissingAccessoryException(EXCEPTION_MESSAGE);
        LOGGER.log(Level.INFO, "Rised chair");
        setHeight(getHeight() + 25);
    }

    @Override
    public void lowerChair() {
        if(getChairSeat() == null) throw new MissingAccessoryException(EXCEPTION_MESSAGE);
        LOGGER.log(Level.INFO, "Lowered chair");
        setHeight(getHeight() - 25);
    }

    @Override
    public void sit() {
        if(getChairSeat() == null) throw new MissingAccessoryException(EXCEPTION_MESSAGE);
        LOGGER.log(Level.INFO, "Siting on bar stool");
    }

    @Override
    public void spin() {
        if(getLegList().contains(null)) throw new MissingAccessoryException("Missing footing");
        LOGGER.log(Level.INFO, "Bar stool spins");
    }


}
