import com.java.bohomolov.sample.BarStool;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BarStoolTest {

    @Test
    public void EqualsTest() {
        BarStool barStool1 = new BarStool(50);
        BarStool barStool2 = new BarStool(50);
        Assert.assertEquals(barStool1, barStool2);
        Assert.assertEquals(barStool1.hashCode(), barStool2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Should_ThrowException_If_MissingSeat() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        BarStool barStool = new BarStool(50);
        barStool.setChairSeat(null);
        barStool.sit();
    }

    @Test
    public void Should_ThrowException_If_MissingFooting() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing footing");

        BarStool barStool = new BarStool(50);
        barStool.setLegs(null);
        barStool.spin();
    }

    @Test
    public void RiseChair_IncreasesHeightBy25_True() {
        int expected = 75;
        BarStool barStool = new BarStool(50);
        barStool.riseChair();
        int actual = barStool.getHeight();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void LowerChair_DecreasesHeightBy25_True() {
        int expected = 25;
        BarStool barStool = new BarStool(50);
        barStool.lowerChair();
        int actual = barStool.getHeight();
        Assert.assertEquals(expected, actual);
    }

}
