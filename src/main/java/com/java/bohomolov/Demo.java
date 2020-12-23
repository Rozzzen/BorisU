package com.java.bohomolov;

import com.java.bohomolov.abstractions.Stool;
import com.java.bohomolov.accessories.*;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.sample.BarStool;
import com.java.bohomolov.sample.FishingStool;
import com.java.bohomolov.sample.GamerChair;
import com.java.bohomolov.sample.WoodenStool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        
//        Stool stool;
//        stool = new BarStool(120);
//        stool.sit();
//        stool = new FishingStool(100);
//        stool.sit();
//
//        List<ChairLeg> chairWheelList = Arrays.asList(
//                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK),
//                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK),
//                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK),
//                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK),
//                new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK)
//        );
//
//        List<Armrest> armrestList = Arrays.asList(
//                new Armrest(Material.PLASTIC, Color.RED),
//                new Armrest(Material.PLASTIC, Color.RED)
//        );
//        GamerChair gamerChair = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList, new ChairBack(Material.CLOTH, Color.RED), armrestList);//

//        try {
//            gamerChair.setChairSeat(null);
//            gamerChair.sit();
//        }
//        catch (MissingAccessoryException exception) {
//            System.out.println(exception.getMessage());
//            switch(exception.getMessage().split(" ")[1]) {
//                case "wheels": {
//                    gamerChair.setLegs(new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK));
//                    System.out.println("Changed wheels");
//                    gamerChair.ride();
//                    break;
//                }
//                case "seat" : {
//                    gamerChair.setChairSeat(new ChairSeat(Material.CLOTH, Color.BLACK));
//                    System.out.println("Changed seat");
//                    gamerChair.sit();
//                    break;
//                }
//                case "back" : {
//                    gamerChair.setChairBack(new ChairBack(Material.CLOTH, Color.BLACK));
//                    System.out.println("Changed back");
//                    gamerChair.tiltBack();
//                    break;
//                }
//            }
//        }
//        finally {
//            System.out.println("Done testing chair");
//        }
//
//
//        WoodenStool woodenStool = new WoodenStool(50, Color.BROWN);
//        WoodenStool woodenStool1 = new WoodenStool(50, Color.BROWN);
//
//        System.out.println(woodenStool);
//
//        WoodenStool.PaintKit paintKit = woodenStool.new PaintKit(Color.RED);
//        paintKit.paintChair();
//
//        System.out.println(woodenStool);
//
//        System.out.println(woodenStool.equals(woodenStool1));
//        System.out.println(woodenStool.hashCode() == woodenStool1.hashCode());
//
//        User user = new User("John");
//        user.sit(woodenStool);
//
    }
}
