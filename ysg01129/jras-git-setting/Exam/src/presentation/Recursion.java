package presentation;

public class Recursion {
	
	public static void main(String[] args) {
		System.out.println("3 factorial : " + factorial(3));
		System.out.println("12 factorial : " + factorial(12));
		
		System.out.println("3 factorial : " + doNotRecursion(3));
		System.out.println("12 factorial : " + doNotRecursion(12));
	}
	
	private static int factorial(int n) {
		if(n==1) {
			return 1;
		} else {
			return n*factorial(n-1);
		}
	}
	
	private static int doNotRecursion(int n) {
		
		int sum = 1;
		
		for(int i=n;i>1;i--) {
			sum = sum*i;
		}
		
		return sum;
	}

}
