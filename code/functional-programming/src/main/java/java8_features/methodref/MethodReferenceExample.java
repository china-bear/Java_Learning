package java8_features.methodref;

import java.util.Comparator;

public class MethodReferenceExample {
	
	// Classname :: methodName

	public static void main(String[] args) {
		System.out.println("Result: "+MethodReferenceExample.compare(10, 20));

		Comparator<Integer> comp1 =  MethodReferenceExample::compare;
		System.out.println("Result: "+comp1.compare(10, 20));

		Comparator<Integer> comp2 =  (x, y) ->  Integer.compare(x, y);
		System.out.println("Result: "+comp2.compare(18, 6));
	}
	
	public static int compare(Integer x,Integer y) {
		return Integer.compare(x, y);
	}

}
