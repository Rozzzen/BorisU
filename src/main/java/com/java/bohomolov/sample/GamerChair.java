package com.java.bohomolov.sample;

import com.java.bohomolov.abstractions.ChairOnWheels;
import com.java.bohomolov.accessories.*;
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
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        System.out.println(getMostFrequentChairWheelColors(gamerChairList));
        System.out.println(getPlasticPriceSum(gamerChair1.getLegList()));
        System.out.println(getAveragePrice(gamerChair1.getLegList()));
        System.out.println(getMaxPrice(gamerChair1.getLegList()));
        System.out.println(gamerChair1.getGroupByMaterialAndPrice(p -> p.getMaterial().equals(Material.PLASTIC) && p.getPrice() < 30));
    }

    public static List<String> getMostFrequentChairWheelColors(List<GamerChair> gamerChairList) {
        List<String> result = new ArrayList<>();
        gamerChairList.stream()
                .flatMap(x -> x.getLegList().stream())
                .collect(Collectors.toList())
                .stream()
                .collect(Collectors.groupingBy(ChairWheel::isRentable))
                .forEach((key, value) -> value.stream()
                        .collect(Collectors.groupingBy(x -> x.getColor().getColor(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(Map.Entry.comparingByValue())
                        .ifPresent(x -> result.add(x.getKey())));
        return result;
    }

    public static double getPlasticPriceSum(List<ChairWheel> list) {
        return list.stream().
                filter(x -> x.getMaterial().equals(Material.PLASTIC)).
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
        return getLegList().stream().
                collect(Collectors.groupingBy(chairWheelPredicate));
    }
}
