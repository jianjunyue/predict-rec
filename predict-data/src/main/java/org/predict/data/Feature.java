package org.predict.data;

public class Feature {

    private int index;

    private float value;

    public Feature() {
    }

    public Feature(int index, float value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
       return this.index + ":" + this.value + " ";
    }
}
