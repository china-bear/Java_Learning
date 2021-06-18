package java8_features.built_in_methods;

import java.util.List;
import java.util.function.Supplier;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

public class SupplierExample {
	
	static Supplier<Person> s1 = () -> PersonRepository.getPerson();
	static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersons();

	public static void main(String[] args) {
		//System.out.println("Result :"+s1.get());
		System.out.println("Result :"+s2.get());
	}

}
