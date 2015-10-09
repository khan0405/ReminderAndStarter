package Study01;

public class Question_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 1;
		System.out.println("===첫번째 별===");
		while (a <= 10) {

			for (int b = 1; b <= a; b++) {
				System.out.print("*");
			}
			System.out.println();
			a++;
		}
		System.out.println("====종료====");

		// 경계선

		System.out.println("===두번째 별====");
		int c = 1;
		while (c <= 10) {
			int d = 1;
			while (d <= c) {
				System.out.print("*");
				d++;
			}
			System.out.println();
			c++;

		}
		System.out.println("===종료===");
	}
}
