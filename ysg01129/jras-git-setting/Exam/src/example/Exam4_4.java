package example;

public class Exam4_4 {

	public static void main(String[] args) {
		
		useModulus();
		usePow();
		
	}
	
	private static void useModulus() {
		int sum = 0;
		int number = 1;
		int count = 0;
		
		while(sum!=100) {			
			if(number%2 == 0) {
				sum-=number;
				System.out.print(" + (-" + number +") + ");
			}
			else {
				sum += number;
				System.out.print(number);
			}			
			number++;
			count++;
		}
		System.out.println();
		System.out.println("°ª : " + sum + "\t\t È½¼ö : " + count);
	}
	
	private static void usePow() {
		int sum = 0;
		int number = 1;
		int count = 0;
		
		while(sum!=100) {
			int operatingNumber = (int) (number * Math.pow(-1, count));
			sum += operatingNumber;
			if(operatingNumber < 0) {
				System.out.print(" + (" + operatingNumber + ") + ");
			}else {
				System.out.print(operatingNumber);
			}
			count++;
			number++;
		}
		System.out.println();
		System.out.println("°ª : " + sum + "\t\t È½¼ö : " + count);		
	}
}
