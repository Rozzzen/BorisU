import com.java.bohomolov.accessories.Armrest;
import com.java.bohomolov.accessories.ChairBack;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.sample.GamerChair;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class StreamApiTest {

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

    @Test
    public void getMostFrequentChairWheelColors_ReturnsTwoMostFrequentColors_True() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        GamerChair gamerChair2 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList2, new ChairBack(Material.CLOTH, Color.RED), armrestList2);//
        List<GamerChair> gamerChairList = Arrays.asList(gamerChair1, gamerChair2);
        List<String> expected = Arrays.asList("Black", "White");
        List<String> actual = GamerChair.getMostFrequentChairWheelColors(gamerChairList);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getPlasticPriceSum_Equals60_True() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        double actual = GamerChair.getPlasticPriceSum(gamerChair1.getLegList());
        double expected = 60;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getAveragePrice_Equals30_True() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        double actual = GamerChair.getAveragePrice(gamerChair1.getLegList());
        double expected = 30;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getMaxPrice_Equals50_True() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        double actual = GamerChair.getMaxPrice(gamerChair1.getLegList());
        double expected = 50;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getGroupByMaterialAndPrice_Filter_True() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        Map<Boolean, List<ChairWheel>> actual = gamerChair1.getGroupByMaterialAndPrice(p -> p.getMaterial().equals(Material.PLASTIC) && p.getPrice() < 30);

        Map<Boolean, List<ChairWheel>> expected = new HashMap<>();
        List<ChairWheel> expectedFalseList = Arrays.asList(
                new ChairWheel(Material.PLASTIC, Color.WHITE, Color.BLACK, true, 30),
                new ChairWheel(Material.STEEL, Color.WHITE, Color.BLACK, true, 50),
                new ChairWheel(Material.WOOD, Color.WHITE, Color.BLACK, true, 40)
        );
        List<ChairWheel> expectedTrueList = Arrays.asList(
                new ChairWheel(Material.PLASTIC, Color.BROWN, Color.BLACK, false, 20),
                new ChairWheel(Material.PLASTIC, Color.BROWN, Color.BLACK, false, 10)
        );

        expected.put(false, expectedFalseList);
        expected.put(true, expectedTrueList);

        Assert.assertEquals(expected, actual);
    }

}
