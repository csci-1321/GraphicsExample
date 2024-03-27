package mygame;

import java.util.ArrayList;
import java.util.Collections;

public class TestGenerics {
    public static void main(String[] args) {
        Integer[] myInts = new Integer[10];
        for (int i = 0; i != 10; ++i) {
            myInts[i] = i*2;
        }
        ArrayList<Integer> lst = converArrayToList(myInts);
        for (Integer integer : lst) {
            //System.out.println(integer.parseInt("71"));
            System.out.println(integer);
        }

        ArrayList<Circle> circles = new ArrayList<Circle>();
        circles.add(new Circle(10,10,5));
        circles.add(new Circle(5,5,7));
        circles.add(new Circle(1,10,20));
        circles.add(new Circle(100,20,1));
        circles.add(new Circle(50,75,4));

        Collections.sort(circles);
        for (Circle c : circles) {
            System.out.println("radius: " + c.radius);
        }
    }

    public static <T> ArrayList<T> converArrayToList(T[] orig) {
	ArrayList<T> converted = new ArrayList<T>();
	for (int i = 0; i != orig.length; ++i) {
		converted.add( orig[i] );
	}
	return converted;
}

}
