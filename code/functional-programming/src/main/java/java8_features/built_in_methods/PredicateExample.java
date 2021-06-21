package java8_features.built_in_methods;

import java.util.function.Predicate;

/**
 * Function：即一个入参一个出参的场景。
 * Consumer：一个入参，但是没有出参
 * Supplier：无入参，一个出参
 * Predicate：可以看做是特殊的Function，一个入参，出参为bool类型。
 */


public class PredicateExample {

	public static void main(String[] args) {
		Predicate<Integer> lessThan = a -> (a <= 50);
		Predicate<Integer> greaterThan = a -> (a >= 100);
		Predicate<Integer> equalTo = a -> (a == 0);
		
		
		/*boolean result = lessThan.test(15);
		System.out.println("Result :"+result);*/
		
		System.out.println("Greater Than :"+greaterThan.test(150));
		System.out.println("Less Than :"+lessThan.test(150));
		System.out.println("Equal :"+equalTo.test(0));
		
		boolean result1 = lessThan.and(greaterThan).and(equalTo).test(150);
		System.out.println("Result 1:"+result1);
		
		boolean result2 = lessThan.or(greaterThan).test(150);
		System.out.println("Result 2:"+result2);
		
		boolean result3 = lessThan.or(greaterThan).negate().test(150);
		System.out.println("Result 3:"+result3);
		
		
		
	}

}
