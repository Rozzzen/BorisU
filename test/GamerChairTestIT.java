import com.java.bohomolov.accessories.ChairWheel;
import com.java.bohomolov.exceptions.MissingAccessoryException;
import com.java.bohomolov.sample.FishingStool;
import com.java.bohomolov.sample.FishingStoolService;
import com.java.bohomolov.sample.GamerChair;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class GamerChairTestIT {

    GamerChair gamerChair = Mockito.mock(GamerChair.class);

    FishingStool fishingStool = Mockito.mock(FishingStool.class);
    FishingStoolService fishingStoolService = new FishingStoolService(fishingStool);

    @Test
    public void IsFolded_EqualsTrue_True_Test() {
        final boolean expected = true;
        Mockito.doReturn(true).when(fishingStool).isFolded();
        boolean actual = fishingStoolService.isFolded();
        Mockito.verify(fishingStool, Mockito.atLeastOnce()).isFolded();
        Assert.assertEquals(actual, expected);
    }

    @Test(expected = MissingAccessoryException.class)
    public void WhenGetLegListThrowException() {
        Mockito.doThrow(new MissingAccessoryException("Missing sit")).when(gamerChair).getLegList();
        gamerChair.getLegList();
    }

    @Test
    public void getMaxPrice_Equals60_True() {
        List<ChairWheel> chairWheelList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ChairWheel chairWheel = Mockito.mock(ChairWheel.class);
            Mockito.when(chairWheel.getPrice()).thenReturn((double)20 + 10 * i);
            chairWheelList.add(chairWheel);
        }
        Assert.assertEquals(GamerChair.getMaxPrice(chairWheelList), 60, 0);
    }
}
