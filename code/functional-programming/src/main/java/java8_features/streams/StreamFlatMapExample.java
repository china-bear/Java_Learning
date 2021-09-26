package java8_features.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class StreamFlatMapExample {
	
	static List<String> hobbies(List<Person> personsList){
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.collect(Collectors.toList());
	}
	
	static List<String> distinctHobbies(List<Person> personsList){
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.sorted()
				.distinct()
				.collect(Collectors.toList());
	}
	
	static long countOfHobbies(List<Person> personsList) {
		return personsList.stream()
				.map(Person :: getHobbies)
				.flatMap(List :: stream)
				.distinct()
				.count();
	}

	public static void main(String[] args) {

		// maring all the streams into one stream
		Stream<List<String>> namesOriginalList = Stream.of(Arrays.asList("Pankaj"), Arrays.asList("David", "Lisa"),
				Arrays.asList("Amit"));

		// flat the stream from List<String> to String stream
		Stream<String> flatStream = namesOriginalList.flatMap(p -> p.stream());
		flatStream.forEach(p -> System.out.println(p));

		List<Integer> oddNumber = Arrays.asList(1,3,5,7);
		List<Integer> evenNumber = Arrays.asList(2,4,6,8);
		
		List<List<Integer>> listofList = Arrays.asList(oddNumber,evenNumber);
		System.out.println("Before Flatten :"+listofList);
		
		List<Integer> flattenList = listofList.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("After Flatten :"+flattenList);
		
		System.out.println("Hobbies Result with Duplicates :"+hobbies(PersonRepository.getAllPersons()));
		System.out.println("Hobbies Result without Duplicates :"+distinctHobbies(PersonRepository.getAllPersons()));
		System.out.println("Hobbies Count :"+countOfHobbies(PersonRepository.getAllPersons()));
	}

}
