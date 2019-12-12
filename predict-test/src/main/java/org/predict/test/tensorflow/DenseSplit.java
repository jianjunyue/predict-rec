package org.predict.test.tensorflow;

import java.util.List;

public class DenseSplit {
    private List<Float> splitPoint;
    private Integer normalIndex;

    public List<Float> getSplitPoint() {
        return splitPoint;
    }

    public void setSplitPoint(List<Float> splitPoint) {
        this.splitPoint = splitPoint;
    }

    public Integer getNormalIndex() {
        return normalIndex;
    }

    public void setNormalIndex(Integer normalIndex) {
        this.normalIndex = normalIndex;
    }
}
