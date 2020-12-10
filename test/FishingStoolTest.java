import com.java.bohomolov.sample.FishingStool;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FishingStoolTest {

    @Test
    public void EqualsTest() {
        FishingStool fishingStool1 = new FishingStool(50);
        FishingStool fishingStool2 = new FishingStool(50);
        Assert.assertEquals(fishingStool1, fishingStool2);
        Assert.assertEquals(fishingStool1.hashCode(), fishingStool2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void Should_ThrowException_If_MissingSeat() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing seat");

        FishingStool fishingStool = new FishingStool(50);
        fishingStool.setChairSeat(null);
        fishingStool.sit();
    }

    @Test
    public void Unfold_UnfoldsChair_True() {
        boolean expected = false;
        FishingStool fishingStool = new FishingStool(50); //Starts folded
        fishingStool.unfold();
        boolean actual = fishingStool.isFolded();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void Fold_FoldsChair_True() {
        boolean expected = true;
        FishingStool fishingStool = new FishingStool(50); //Starts folded
        fishingStool.fold();
        boolean actual = fishingStool.isFolded();
        Assert.assertEquals(expected, actual);
    }
}
