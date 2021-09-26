package java8_features.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamIterate {
	public static void main(String[] args) {

		// iterate(seed,function that is expanded)
		Stream.iterate("good news", p -> p + "!").limit(10).skip(2).forEach(p -> System.out.println(p));

		// multiply by 2
		Stream.iterate(1, p -> p * 2).limit(10).skip(2).forEach(p -> System.out.println(p));

		// what about fibonacchi? it needs previous 2 variables it cant be done
		// with iterate

		FibMaker f_gen = new FibMaker(Long.valueOf(-1), Long.valueOf(1));
		Stream.generate(f_gen).limit(10).forEach(System.out::println);

		MyClass m = new MyClass();
		m.a0 = -1;
		m.a1 = 1;

		// multiply by 2
		Stream.iterate(m, p -> {
			int i = p.a0;
			p.a0 = p.a1;
			p.a1 = (p.a0 + i);
			return p;
		}).limit(10).skip(2).forEach(p -> System.out.println(p.a1));
	}

	public static class FibMaker implements Supplier<Long> {
		private Long p1, p2;
		public FibMaker(Long i, Long j) {
			p1 = i;
			p2 = j;
		}

		public Long get() {
			Long ret = p1 + p2;
			p1 = p2;
			p2 = ret;
			return ret;
		}
	}

	private static class MyClass {
		int a1, a0;
	}

}
