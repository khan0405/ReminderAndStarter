package Study02;

public class Question_3 {
	public static void main(String[] args) {

		int[] coinunit = { 500, 100, 50, 10 };

		int money = 4260;

		System.out.println("Money = " + money + "");

		for (int i = 0; i < coinunit.length; i++) {

			System.out.println(coinunit[i] + "원 : " + money / coinunit[i] + "개");
			money = money - (money / coinunit[i]) * coinunit[i];

		}

	}
}
