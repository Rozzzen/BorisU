import com.java.bohomolov.enums.Color;
import com.java.bohomolov.sample.WoodenStool;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class WoodenStoolTest {

    @Test
    public void EqualsTest() {
        WoodenStool woodenStool1 = new WoodenStool(50, Color.RED);
        WoodenStool woodenStool2 = new WoodenStool(50, Color.RED);

        Assert.assertEquals(woodenStool1, woodenStool2);
        Assert.assertEquals(woodenStool1.hashCode(), woodenStool2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Should_ThrowException_If_MissingSeat() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        WoodenStool woodenStool = new WoodenStool(50, Color.RED);
        woodenStool.setChairSeat(null);
        woodenStool.sit();

    }

    @Test
    public void PaintKit_PaintChairRed_True() {

        WoodenStool actual = new WoodenStool(50, Color.RED);
        WoodenStool expected = new WoodenStool(50, Color.BROWN);
        WoodenStool.PaintKit paintKit = expected.new PaintKit(Color.RED);
        paintKit.paintChair();
        Assert.assertEquals(actual, expected);

    }
}
