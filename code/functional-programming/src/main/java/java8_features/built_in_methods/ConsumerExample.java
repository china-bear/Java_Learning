package java8_features.built_in_methods;

import java.util.function.Consumer;

/**
 * Function：即一个入参一个出参的场景。
 * Consumer：一个入参，但是没有出参
 * Supplier：无入参，一个出参
 * Predicate：可以看做是特殊的Function，一个入参，出参为bool类型。
 */


public class ConsumerExample {

	public static void main(String[] args) {
		Consumer<String> con1 = (s) -> {System.out.println(s.toUpperCase());};
		//con1.accept("java8");
		Consumer<String> con2 = (s) -> System.out.println(s.toLowerCase());
		//con2.accept("java8");
		con1.andThen(con2).accept("java8");
	}

}
