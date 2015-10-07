package jras.study.homework;

public class Exercise5_6 {
	public static void main(String[] args) {
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		System.out.printf("money = %d\n", money);
		
		for (int coin : coinUnit) {
			int countAsCoin = money / coin;
			System.out.printf("%d원: %d\n", coin, countAsCoin);
			money = money % coin;
		}
	}
}
