import com.java.bohomolov.accessories.Armrest;
import com.java.bohomolov.accessories.ChairBack;
import com.java.bohomolov.accessories.ChairSeat;
import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.enums.Color;
import com.java.bohomolov.enums.Material;
import com.java.bohomolov.sample.GamerChair;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.List;

public class GamerChairTest {

    private final List<ChairWheel> chairWheelList1 = Arrays.asList(
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, false, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, false, 10)
    );
    private final List<ChairWheel> chairWheelList2 = Arrays.asList(
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, true, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, false, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, false, 10),
            new ChairWheel(Material.PLASTIC, Color.RED, Color.BLACK, false, 10)
    );

    private final List<Armrest> armrestList1 = Arrays.asList(
            new Armrest(Material.PLASTIC, Color.RED),
            new Armrest(Material.PLASTIC, Color.RED)
    );
    private final List<Armrest> armrestList2 = Arrays.asList(
            new Armrest(Material.PLASTIC, Color.RED),
            new Armrest(Material.PLASTIC, Color.RED)
    );

    @Test
    public void EqualsTest() {
        GamerChair gamerChair1 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        GamerChair gamerChair2 = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList2, new ChairBack(Material.CLOTH, Color.RED), armrestList2);//

        Assert.assertEquals(gamerChair1, gamerChair2);
        Assert.assertEquals(gamerChair1.hashCode(), gamerChair2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Should_ThrowException_If_MissingSeat() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        GamerChair gamerChair = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        gamerChair.setChairSeat(null);
        gamerChair.sit();
    }

    @Test
    public void Should_ThrowException_If_MissingBack() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing back");

        GamerChair gamerChair = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        gamerChair.setChairBack(null);
        gamerChair.tiltBack();
    }

    @Test
    public void Should_ThrowException_If_MissingWheels() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing wheels");

        GamerChair gamerChair = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        gamerChair.setLegs(null);
        gamerChair.ride();

    }

    @Test
    public void ToStringTest() {
        String expected = "Height: 65" + System.lineSeparator() +
                "Designed in High-tech style" + System.lineSeparator() +
                "With 5 legs Footing made of Red color Plastic. Wheel color is Black" + ", Price is: 10.0" + System.lineSeparator() +
                "Chair seat made of Red color Cloth" + System.lineSeparator() +
                "Chair back made of Red color Cloth" + System.lineSeparator() +
                "Armrests made of Red color Plastic" + System.lineSeparator();
        GamerChair gamerChair = new GamerChair(65, new ChairSeat(Material.CLOTH, Color.RED), chairWheelList1, new ChairBack(Material.CLOTH, Color.RED), armrestList1);//
        String actual = gamerChair.toString();
        Assert.assertEquals(expected, actual);
    }
}
