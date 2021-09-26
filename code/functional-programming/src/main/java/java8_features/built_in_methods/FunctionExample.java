package java8_features.built_in_methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Function：即一个入参一个出参的场景。
 * Consumer：一个入参，但是没有出参
 * Supplier：无入参，一个出参
 * Predicate：可以看做是特殊的Function，一个入参，出参为bool类型。
 */

public class FunctionExample {
	
	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = name -> name.toUpperCase().concat(" features");
	// using the function util
	static Function<String, String> tuper = p -> {

		int i;
		String ret = "";
		for (i = 0; i < p.length(); i++) {
			ret += (char) (p.charAt(i) + 'A' - 'a');
		}
		return ret;
	};

	public static void main(String[] args) {
		//System.out.println("Result 1:"+f1.apply("java"));
		//System.out.println("Result 2:"+f2.apply("java"));
		System.out.println("And Then Result :"+ f1.andThen(f2).apply("java"));
		System.out.println("Compose Result :"+f1.compose(f2).apply("java"));

		Stream<String> names = Stream.of("abc", "d", "ef");
		System.out.println(names.map(tuper).collect(Collectors.toList())); // prints [ABC, D, EF]

		List<Person> list1 = Person.createShortList();

		// Define Western and Eastern Lambdas

		Function<Person, String> westernStyle = p -> "\nName1: " + " " + p.getSurName() + "\n";

		Function<Person, String> easternStyle = p -> "\nName2: " + " " + p.getSurName() + "\n";

		// Print Western List
		System.out.println("\n===Western List===");
		for (Person person : list1) {
			System.out.println(person.printCustom(westernStyle));
		}

		// Print Eastern List
		System.out.println("\n===Eastern List===");
		for (Person person : list1) {
			System.out.println(person.printCustom(easternStyle));
		}

	}

	private static class Person {
		private String surName;
		private int age;
		private String gender;

		public Person(String sur) {
			surName = sur;
			age = 17;
			gender = "Male";
		}

		public void printName() {
			System.out.println(surName);
		}

		public String printCustom(Function<Person, String> f) {
			return f.apply(this);
		}

		public static List<Person> createShortList() {
			List<Person> people = new ArrayList<>();

			people.add(new Person("z"));
			people.add(new Person("x"));
			people.add(new Person("c"));

			return people;
		}

		String getSurName() {
			return surName;
		}

		int getAge() {
			return age;
		}

		String getGender() {
			return gender;
		}

	}
}
