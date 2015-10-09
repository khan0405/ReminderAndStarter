package Study02;

public class Question_4 {
	public static void main(String[] args) {

		int money = 100;

		int[] coinunit = { 500, 100, 50, 10 };
		int[] coin = { 5, 5, 5, 5 };

		for (int i = 0; i < coinunit.length; i++) {
			int coinNum = 0;
			/*
			 * 금액을 동전단위로 나눠서필요한 동전 갯수 구함 배열 코인에서동전갯수만큼 뺀다 금액에서 동전단위와 갯수곱한 만큼 뺀다
			 */

			coinNum = money / coinunit[i]; // 필요 동전 갯수
			if (coinNum > 5) {
				coinNum = 5;
			}
			coin[i] = coin[i] - coinNum; // 거스름 가능 갯수 - 필요 동전 갯수
			money = money - coinNum * coinunit[i]; // 현재 금액에 필요동전*단위 값 대입
			System.out.println(coinunit[i] + "원 : " + coinNum);

		}
		if (money > 0) {

			System.out.println("거스름 돈 " + money + "원 부족합니다.");
			System.exit(0);
		}
		System.out.println("남은 동전 갯수");

		for (int i = 0; i < coinunit.length; i++) {

			System.out.println(coinunit[i] + "원 : " + coin[i]);
		}
	}

}
