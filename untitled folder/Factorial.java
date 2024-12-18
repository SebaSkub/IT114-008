public class Factorial {
	// from https://www.programiz.com/java-programming/recursion
	static int factorial(int n) {
		if (n != 0) // termination condition
			return n * factorial(n - 1); // recursive call
		else
			return 1;
	}

	public static void main(String[] args) {
		int number = 2, result;
		result = factorial(number);
		System.out.println(number + " factorial = " + result);
	}
}