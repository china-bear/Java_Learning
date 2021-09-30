package java8_features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class StreamsVsCollectionExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("John");
		names.add("Adan");
		names.add("Nancy");
		

		for(String name : names) {
			System.out.println("Iteration :"+name);
		}
		
		Stream<String> stream = names.stream();
		stream.forEach(p -> System.out.println("<<<< :"+p));

		List<String> personNames = PersonRepository
				.getAllPersons()
				.stream()
				.peek(per -> System.out.println(per))
				.map(Person :: getName)
				.peek(System.out :: println)
				.collect(Collectors.toList());
	}

}
