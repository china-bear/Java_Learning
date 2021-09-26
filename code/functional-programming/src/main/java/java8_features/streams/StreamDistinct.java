package java8_features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinct {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 12, 451 - 4, -8, 10);

		System.out.println(list.stream().sorted((p1, p2) -> p1 - p2).distinct().collect(Collectors.toList()));
		// output:[-8, 10, 12, 447]

	}

}
