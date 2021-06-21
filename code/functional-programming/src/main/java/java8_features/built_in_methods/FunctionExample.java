package java8_features.built_in_methods;

import java.util.function.Function;

/**
 * Function：即一个入参一个出参的场景。
 * Consumer：一个入参，但是没有出参
 * Supplier：无入参，一个出参
 * Predicate：可以看做是特殊的Function，一个入参，出参为bool类型。
 */

public class FunctionExample {
	
	static Function<String, String> f1 = name -> name.toUpperCase();
	static Function<String, String> f2 = name -> name.toUpperCase().concat(" features");

	public static void main(String[] args) {
		//System.out.println("Result 1:"+f1.apply("java"));
		//System.out.println("Result 2:"+f2.apply("java"));
		System.out.println("And Then Result :"+ f1.andThen(f2).apply("java"));
		System.out.println("Compose Result :"+f1.compose(f2).apply("java"));
	}

}
