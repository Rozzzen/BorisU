package com.java.bohomolov.sample;

public class FishingStoolService {
    FishingStool fishingStool;

    public FishingStoolService(FishingStool fishingStool) {
        this.fishingStool = fishingStool;
    }

    public boolean isFolded() {
        return fishingStool.isFolded();
    }
}
