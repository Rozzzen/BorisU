package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.StoolOnWheels;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.interfaces.Rideable;
import com.java.bohomolov.interfaces.Spinable;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GrasseStool extends StoolOnWheels implements Rideable, Spinable {

    private static final Logger LOGGER = Logger.getGlobal();

    public GrasseStool(int height, Color color) {
        super(height, Style.MODERN, new ChairSeat(Material.LEATHER, color),  Arrays.asList(
                new ChairWheel(Material.LEATHER, color, color, true, 10),
                new ChairWheel(Material.LEATHER, color, color, true, 10),
                new ChairWheel(Material.LEATHER, color, color, true, 10),
                new ChairWheel(Material.LEATHER, color, color, true, 10)));
    }

    @Override
    public void sit() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        LOGGER.log(Level.INFO, "Siting on grasse stool");
    }

    @Override
    public void ride() {
        if(getLegList().contains(null)) throw new MissingAccessoryException("Missing wheels");
        LOGGER.log(Level.INFO, "Riding on grasse stool");
    }

    @Override
    public void spin() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        LOGGER.log(Level.INFO, "Spining on grasse stool");
    }
}
