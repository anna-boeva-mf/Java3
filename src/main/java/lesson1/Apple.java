package lesson1;


public class Apple extends Fruit {
    private static final String FRUIT_NAME = "Apple";
    private String color;
    private static final float WEIGHT = 1.f;

    public Apple() {
    }

    public Apple(String color) {
        this.color = color;
    }

    public float getWEIGHT() {
        return WEIGHT;
    }

    public String toString() {
        return "{%s: %s, %s}".formatted(FRUIT_NAME, color, WEIGHT);
    }
}
