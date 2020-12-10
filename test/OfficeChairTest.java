import com.java.bohomolov.sample.OfficeChair;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class OfficeChairTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void EqualsTest() {
        OfficeChair officeChair1 = new OfficeChair(50);
        OfficeChair officeChair2 = new OfficeChair(50);

        Assert.assertEquals(officeChair1, officeChair2);
        Assert.assertEquals(officeChair1.hashCode(), officeChair2.hashCode());
    }

    @Test
    public void Should_ThrowException_If_MissingSeat() {

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        OfficeChair officeChair = new OfficeChair(50);
        officeChair.setChairSeat(null);
        officeChair.sit();

    }

}
