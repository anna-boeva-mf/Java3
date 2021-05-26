package lesson1;


import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("///////task1");
        Integer[] testIntArray = {1, 3, 5, 7, 16, 56, 344};
        System.out.println(Arrays.asList(testIntArray));
        System.out.println(Arrays.asList(exchangeTwoElements(1, 4, testIntArray)));
        System.out.println("///////task2");
        String[] testStringArray = {"ad", "sf", "dg", "fh", "gj"};
        System.out.println(testStringArray.getClass());
        System.out.println(arrayToArrayList(testStringArray).getClass());
        System.out.println("///////task3");
        ArrayList<Apple> appleArrayList = new ArrayList<>();
        appleArrayList.add(new Apple("red"));
        appleArrayList.add(new Apple("yellow"));
        appleArrayList.add(new Apple("green"));
        Box<Apple> appleBox = new Box<>();
        appleBox.setFruitList(appleArrayList);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange(3));
        orangeBox.addFruit(new Orange(5));

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        Box<Orange> orangeBox2 = new Box<>();
        orangeBox2.addFruit(new Orange(2));
        System.out.println(orangeBox.getFruitList() + " " + orangeBox2.getFruitList());
        orangeBox.exchangeBoxes(orangeBox2);
        System.out.println(orangeBox.getFruitList() + " " + orangeBox2.getFruitList());
    }

    public static <E> E[] exchangeTwoElements(int ind1, int ind2, E... array) {
        E interElement = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = interElement;
        return array;
    }

    public static <E> ArrayList<E> arrayToArrayList(E... array) {
        ArrayList<E> arrayList = new ArrayList<E>(Arrays.asList(array));
        return (arrayList);
    }
}

