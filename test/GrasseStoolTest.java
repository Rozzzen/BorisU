import com.java.bohomolov.enums.Color;
import com.java.bohomolov.sample.GrasseStool;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GrasseStoolTest {

    @Test
    public void EqualsTest() {
        GrasseStool grasseStool1 = new GrasseStool(50, Color.BLACK);
        GrasseStool grasseStool2 = new GrasseStool(50, Color.BLACK);
        Assert.assertEquals(grasseStool1, grasseStool2);
        Assert.assertEquals(grasseStool1.hashCode(), grasseStool2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Should_ThrowException_If_MissingSeat() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        GrasseStool grasseStool = new GrasseStool(50, Color.RED);
        grasseStool.setChairSeat(null);
        grasseStool.sit();

    }

    @Test
    public void Should_ThrowException_If_MissingWheels() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing wheels");

        GrasseStool grasseStool = new GrasseStool(50, Color.WHITE);
        grasseStool.setLegs(null);
        grasseStool.ride();

    }
}
