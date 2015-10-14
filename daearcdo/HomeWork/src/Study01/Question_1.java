
package Study01;

public class Question_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int Sum = 0;

		for (int i = 1; i <= 10; i++) {
			for (int h = 1; h <= i; h++) {
				Sum += h;
				System.out.println("더한 수" + Sum);
			}
		}

	}

}
