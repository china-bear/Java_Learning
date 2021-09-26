package java8_features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamParallel {
	public static void timingTest(Stream<Person> teststream) {
		long start = System.nanoTime();
		teststream.forEach(p -> p.doSlowOp());
		long end = System.nanoTime();
		System.out.println(deltaSecond(end - start));
	}

	public static double deltaSecond(long val) {
		return val / 1000000000;
	}

	public static void main(String[] args) {

		int processors = Runtime.getRuntime().availableProcessors();

		// sequential stream
		Stream<Person> sequentialStream = Person.createShortList().stream();
		System.out.println("time taken for serial version on " + processors + " core machine ");
		timingTest(sequentialStream);

		// parallel stream
		Stream<Person> parallelStream = Person.createShortList().parallelStream();
		System.out.println("time taken for paralel version on " + processors + " core machine ");
		timingTest(parallelStream);

	}

	private static class Person {
		private String surName;
		private int age;
		private String gender;

		public Person(String sur, int ag) {
			surName = sur;
			age = ag;
			gender = "Male";
		}

		public void doSlowOp() {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ie) {
				//
			}
		}

		public void printName() {
			System.out.println(surName);
		}

		public String printCustom(Function<Person, String> f) {
			return f.apply(this);
		}

		public static List<Person> createShortList() {
			List<Person> people = new ArrayList<>();

			people.add(new Person("z", 16));
			people.add(new Person("x", 17));
			people.add(new Person("c", 18));

			people.add(new Person("a", 16));
			people.add(new Person("b", 17));
			people.add(new Person("d", 18));

			return people;
		}

		public String getSurName() {
			return surName;
		}

		public int getAge() {
			return age;
		}

		public String getGender() {
			return gender;
		}

	}
}
