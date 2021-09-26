package java8_features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class StreamMapExample {
	
	static List<String> toUpperTransform(List<Person> listOfPersons){
		return listOfPersons.stream()
				.map(Person :: getName)
				.map(String :: toUpperCase)
				.collect(Collectors.toList());
	}
	
	static Set<String> toUpperTransformSet(List<Person> listOfPersons){
		return listOfPersons.stream()
				.map(Person :: getName)
				.map(String :: toUpperCase)
				.collect(Collectors.toSet());
	}

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("Apple","Orange","Banana","Pineapple");
		List<Integer> fruitLength = fruits.stream()
		.map(String :: length)
		.collect(Collectors.toList());
		System.out.println("Length List :"+fruitLength);
		System.out.println("To Uppercase Result :"+toUpperTransform(PersonRepository.getAllPersons()));
		System.out.println("To Uppercase Set Result :"+toUpperTransformSet(PersonRepository.getAllPersons()));

		// We can use map() to apply functions to an stream.
		// Let's see how we can use it to apply upper case function to a list of
		// Strings.
		Stream<String> names = Stream.of("aBc", "d", "ef");
		System.out.println(names.map(s -> {
			return s.toUpperCase();
		}).collect(Collectors.toList()));
		// prints [ABC, D, EF]
		
	}

}
