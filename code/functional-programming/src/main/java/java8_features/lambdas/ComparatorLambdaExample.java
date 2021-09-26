package java8_features.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorLambdaExample {

	public static void main(String[] args) {
		// Before
		Comparator<Integer> c1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				return x.compareTo(y);
			}
		};
		
		System.out.println("Comparator1 :"+c1.compare(15, 15)); //0 
		
		//After
		Comparator<Integer> c2 = (Integer x, Integer y) -> x.compareTo(y);
		System.out.println("Comparator2 :"+c2.compare(25, 15)); // 1
		
		Comparator<Integer> c3 = (x, y) -> x.compareTo(y);
		System.out.println("Comparator3 :"+c3.compare(15, 25)); // -1


		List<Person> personList = Person.createShortList();

		// Sort with Inner Class
		Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});

		System.out.println("=== Sorted Asc SurName ===");
		for (Person p : personList) {
			p.printName();
		}

		// Use Lambda instead

		// Print Asc
		System.out.println("=== Sorted Asc SurName ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

		for (Person p : personList) {
			p.printName();
		}

		// Print Desc
		// no need of type
		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList, (p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));

		for (Person p : personList) {
			p.printName();
		}

		// using braces
		// Print Desc (not a good way but good for learning)
		System.out.println("=== Sorted Desc SurName ===");
		Collections.sort(personList, (p1, p2) -> {
			return p2.getSurName().compareTo(p1.getSurName());
		});

		for (Person p : personList) {
			p.printName();
		}

	}

	private static class Person {
		private String givenName;
		private String surName;
		private int age;
		private String eMail;
		private String phone;
		private String address;
		private String gender;

		public Person(String sur) {
			surName = sur;
		}

		public void printName() {
			System.out.println(surName);
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

	}

}
