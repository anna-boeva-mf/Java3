package lesson1;


public class Orange extends Fruit{
    private static final String FRUIT_NAME = "Orange";
    private int bonesCount;
    private static final float WEIGHT = 1.5f;

    public Orange() {
    }
    public Orange(int bonesCount) {
        this.bonesCount = bonesCount;
    }
    public float getWEIGHT() {
        return WEIGHT;
    }

    public String toString() {
        return "{%s: %s, %s}".formatted(FRUIT_NAME, bonesCount, WEIGHT);
    }
}
