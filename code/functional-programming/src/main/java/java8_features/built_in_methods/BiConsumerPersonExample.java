package java8_features.built_in_methods;

import java8_features.repo.Person;
import java8_features.repo.PersonRepository;

import java.util.List;
import java.util.function.BiConsumer;



public class BiConsumerPersonExample {
	
	static void printPersonDetails() {
		BiConsumer<String, List<String>> personConsumer = (name,hobbies) -> System.out.println(name +" "+hobbies);
		BiConsumer<String, Double> salaryConsumer = (name,salary) -> System.out.println(name +" "+salary);
		
		List<Person> personList = PersonRepository.getAllPersons();
		
		//personList.forEach(per -> personConsumer.accept(per.getName(), per.getHobbies()));
		personList.forEach(per -> {
			personConsumer.accept(per.getName(), per.getHobbies());
			salaryConsumer.accept(per.getName(),per.getSalary());
		});
	}

	public static void main(String[] args) {
		printPersonDetails();
	}

}
