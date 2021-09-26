package java8_features.lambdas;

public class RunnableLambdaExample {

	public static void main(String[] args) {

		// Before  Anonymous Runnable
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1");
			}
		};

		new Thread(t1).start();

		// After Lambda Runnable
		Runnable t2 = () -> System.out.println("Thread 2");
		new Thread(t2).start();

		// Lambda Runnable with block
		Runnable t3 = () -> {
			System.out.println("Thread 3");
			System.out.println("Thread 3.1");
		};
		new Thread(t3).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 4");

			}
		}).start();

		// Lambda Runnable with block
		new Thread(() -> {
			System.out.println("Thread 5");
			System.out.println("Thread 5.1");
		}).start();
	}
}
