package java8_features.built_in_methods;

import java.util.List;
import java.util.function.Supplier;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;


/**
 * Function：即一个入参一个出参的场景。
 * Consumer：一个入参，但是没有出参
 * Supplier：无入参，一个出参
 * Predicate：可以看做是特殊的Function，一个入参，出参为bool类型。
 */

public class SupplierExample {
	
	static Supplier<Person> s1 = () -> PersonRepository.getPerson();
	static Supplier<List<Person>> s2 = () -> PersonRepository.getAllPersons();

	public static void main(String[] args) {
		//System.out.println("Result :"+s1.get());
		System.out.println("Result :"+s2.get());
	}

}
