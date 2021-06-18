package java8_features.built_in_methods;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class PredicatePersonExample {
	
	static Predicate<Person> p1 = per -> per.getHeight() >= 140;
	
	static Predicate<Person> p2 = per -> per.getGender().equals("Male");

	public static void main(String[] args) {
		List<Person> personList = PersonRepository.getAllPersons();
		
		personList.stream()
		.filter(p1)
		.collect(Collectors.toList());
		
		personList.forEach(per -> {
			if(p1.and(p2).test(per)) {
				System.out.println(per);
			}
		});
	}

}
