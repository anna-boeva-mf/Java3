package lesson1;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> {

    private List<E> fruitList = new ArrayList<>();

    public void setFruitList(List<E> fruitList) {
        this.fruitList = fruitList;
    }

    public List<E> getFruitList() {
        return fruitList;
    }

    public void addFruit(E fruit) {
        fruitList.add(fruit);
    }

    public float getWeight() {
        float weight = 0f;
        for (E fruit : fruitList) {
            weight += fruit.getWEIGHT();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void exchangeBoxes(Box<E> box2) {
        Box<E> changeBox = new Box<>();
        changeBox.fruitList = this.fruitList;
        this.fruitList = box2.fruitList;
        box2.fruitList = changeBox.fruitList;
    }
}
