package java8_features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamReduceExample {

	public static void main(String[] args) {
		List<Integer> listofIntegers = Arrays.asList(1,2,3,4,5);
		int sum = listofIntegers.stream().mapToInt(i -> i).sum();
		System.out.println("Sum Result :"+sum);
		System.out.println(listofIntegers.stream().mapToInt(i -> i).count());
		
		System.out.println("Result of Multiplication :"+listofIntegers.stream().reduce(1, (a,b) -> a*b));
		// 1*1 = 1
		// 1*2 = 2
		// 2*3 = 6
		// 6*4 = 24
		// 24*5 = 120
		
		System.out.println("Result of Addition :"+listofIntegers.stream().reduce(0, (a,b) -> a+b));

		List<String> list = Arrays.asList("ab", "b", "c", "d", "e");
		Stream<String> st = list.stream();

		// reduce(initval,function to merge)
		String ret = st.reduce("", (p1, p2) -> p1 + p2);
		System.out.println(ret);
		// output: abbcde

		st = list.stream();
		ret = st.reduce("", (p1, p2) -> p2 + p1);
		System.out.println(ret); // output: edcbab

		// sum
		List<Integer> ls = Arrays.asList(3, 4, 5, 1, 0, -1);
		System.out.println(ls.stream().reduce(0, (p1, p2) -> p1 + p2)); // output:12

		// finding max
		System.out.println(ls.stream().reduce(0, (p1, p2) -> Math.max(p1, p2))); // output: 5
	}

}
