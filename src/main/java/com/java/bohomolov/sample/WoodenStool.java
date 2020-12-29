package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.Stool;
import com.java.bohomolov.accessories.ChairLeg;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WoodenStool extends Stool {

    private static final Logger LOGGER = Logger.getGlobal();

    public class PaintKit {
        Color color;

        public PaintKit(Color color) {
            this.color = color;
        }

        public void paintChair() {
            WoodenStool.this.getChairSeat().setChairSeatColor(color);
            WoodenStool.this.getLegList().forEach(x -> x.setChairLegColor(color));
        }

    }

    public WoodenStool(int height, Color color) {
        super(height, Style.CLASSIC, new ChairSeat(Material.WOOD, color), Arrays.asList(
                new ChairLeg(Material.WOOD, color),
                new ChairLeg(Material.WOOD, color),
                new ChairLeg(Material.WOOD, color),
                new ChairLeg(Material.WOOD, color)
        ));
    }

    @Override
    public void sit() {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        LOGGER.log(Level.INFO, "Siting on wooden stool");
    }
}
