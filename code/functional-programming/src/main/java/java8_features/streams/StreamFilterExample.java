package java8_features.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class StreamFilterExample {
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140;
	static Predicate<Person> p2 = per -> per.getGender().equals("Male");

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Sam","Anderson","Peter","Nancy");
		
		Stream<String> allNames = names.stream();
		
		Stream<String> updatesList = allNames.filter(s -> s.length() > 3);
		
		updatesList.forEach(System.out :: println);
		
		names.stream().filter(s-> s.length()>3).collect(Collectors.toList()).forEach(System.out :: println);
		
		PersonRepository.getAllPersons()
		.stream()
		.filter(p1.and(p2))
		//.filter(p2)
		.collect(Collectors.toList()).forEach(System.out :: println);
		
		/*List<Person> l1 = PersonRepository.getAllPersons()
				.stream()
				.filter(per -> per.getHeight() >= 140)
				.collect(Collectors.toList());
		l1.forEach(System.out :: println);*/

		// create a dumb list
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// filter foreach
		Stream<Integer> highNums = myList.stream().filter(p -> p > 90); // filter
																		// numbers
																		// greater
																		// than
																		// 90
		System.out.print("High Nums greater than 90=");
		highNums.forEach(p -> System.out.print(p + " "));
		// prints "High Nums greater than 90=91 92 93 94 95 96 97 98 99 "
		System.out.println("");

	}


}
