package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.ChairOnWheels;
import com.java.bohomolov.accessories.Armrest;
import com.java.bohomolov.accessories.ChairBack;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.enums.Style;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.interfaces.Rideable;
import com.java.bohomolov.interfaces.Spinable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GamerChair extends ChairOnWheels  implements Rideable, Spinable {

    private static final Logger GAMERCHAIRLOGGER = Logger.getGlobal();

    public GamerChair(int height, ChairSeat chairSeat, List<ChairWheel> legList, ChairBack chairBack, List<Armrest> armrestList) {
        super(height, Style.HIGHTEC, chairSeat, legList, chairBack, armrestList);
    }

    @Override
    public void sit() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        GAMERCHAIRLOGGER.log(Level.INFO, "Sit on gamer chair");
    }

    @Override
    public void ride() {
        if(getLegList().contains(null)) throw new MissingAccessoryException("Missing wheels");
        GAMERCHAIRLOGGER.log(Level.INFO, "Riding on gamer chair");
    }

    public void tiltBack() {
        if(getChairBack() == null) throw new MissingAccessoryException("Missing back");
        GAMERCHAIRLOGGER.log(Level.INFO,"tilted chair back");
    }

    @Override
    public void spin() throws MissingAccessoryException {
        if(getChairSeat() == null) throw new MissingAccessoryException("Missing seat");
        GAMERCHAIRLOGGER.log(Level.INFO, "Spin on gamer chair");
    }

    public static void main(String[] args) {
         final List<ChairWheel> chairWheelList1 = Arrays.asList(
                new ChairWheel(Material.PLASTIC, Color.WHITE, Color.BLACK, true, 30),
                new ChairWheel(Material.STEEL, Color.WHITE, Color.BLACK, true, 50),
                new ChairWheel(Material.WOOD, Color.WHITE, Color.BLACK, true, 40),
                new ChairWheel(Material.PLASTIC, Color.BROWN, Color.BLACK, false, 20),
                new ChairWheel(Material.PLASTIC, Color.BROWN, Color.BLACK, false, 10)
        );
         final List<ChairWheel> chairWheelList2 = Arrays.asList(
                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
                new ChairWheel(Material.PLASTIC, Color.BLACK, Color.BLACK, false, 10),
                new ChairWheel(Material.PLASTIC, Color.BLACK, Color.BLACK, false, 10),
                new ChairWheel(Material.PLASTIC, Color.BLACK, Color.BLACK, false, 10)
         );

        final List<Armrest> armrestList1 = Arrays.asList(
                new Armrest(Material.PLASTIC, Color.RED),
                new Armrest(Material.PLASTIC, Color.RED)
        );
        final List<Armrest> armrestList2 = Arrays.asList(
                new Armrest(Material.LEATHER, Color.BLACK),
                new Armrest(Material.LEATHER, Color.BLACK)
        );

        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        GamerChair gamerChair2 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList2, new ChairBack(Material.CLOTH, Color.RED), armrestList2);//
        List<GamerChair> gamerChairList = Arrays.asList(gamerChair1, gamerChair2);
        GAMERCHAIRLOGGER.info((Supplier<String>) getMostFrequentChairWheelColors(gamerChairList));
        GAMERCHAIRLOGGER.info(String.valueOf(getPlasticPriceSum(gamerChair1.getWheelList())));
        GAMERCHAIRLOGGER.info(String.valueOf(getAveragePrice(gamerChair1.getWheelList())));
        GAMERCHAIRLOGGER.info(String.valueOf(getMaxPrice(gamerChair1.getWheelList())));
        GAMERCHAIRLOGGER.info(gamerChair1.getGroupByMaterialAndPrice(p -> p.getChairLegMaterial().equals(Material.PLASTIC) && p.getPrice() < 30).toString());
    }

    public static List<String> getMostFrequentChairWheelColors(List<GamerChair> gamerChairList) {
        List<String> result = new ArrayList<>();
        gamerChairList.stream()
                .flatMap(x -> x.getWheelList().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(ChairWheel::isRentable))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getChairLegColor().getColour(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

    public static double getPlasticPriceSum(List<ChairWheel> list) {
        return list.stream().
                filter(x -> x.getChairLegMaterial().equals(Material.PLASTIC)).
                mapToDouble(ChairWheel::getPrice).
                sum();
    }

    public static double getAveragePrice(List<ChairWheel> list) {
        return list.stream().
                mapToDouble(ChairWheel::getPrice).
                average().getAsDouble();
    }

    public static double getMaxPrice(List<ChairWheel> list) {
        return list.stream().
                mapToDouble(ChairWheel::getPrice).
                max().getAsDouble();
    }

    public Map<Boolean, List<ChairWheel>> getGroupByMaterialAndPrice(Function<ChairWheel, Boolean> chairWheelPredicate) {
        return getWheelList().stream().
                collect(Collectors.groupingBy(chairWheelPredicate));
    }
}
