package java8_features;

@FunctionalInterface
public interface TestInterface {
	public void add();	

	default String sayHi() {
		return "Hi";
	}
	
	static boolean isTrue() {
		return true;
	}
}
