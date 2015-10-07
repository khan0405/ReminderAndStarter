package example1007;

import java.util.Scanner;

/**
 * 남은 동전의 개수와 사용한 동전의 개수를 구하는 프로그램 입니다.
 * 
 * @author HunJin
 *
 */
public class Exam5_7 {

	static int[] coinUnit = {500, 100, 50, 10 };
	static int[] coin     = {5, 5, 5, 5};
	static int[] count = new int[coin.length];
	static int money = 0;


	public static void main(String[] args) {

		inputMoney(); // 입력 받는 함수

		calcMoney();  // 돈 계산
		
		judgeMoney(); // 남은 돈이 있는지 판단

		printRemind();  // 남은 동전 출력

	}

	
	/**
	 * 돈을 입력받는 메서드 입니다.
	 */
	private static void inputMoney() {
		Scanner scanner = new Scanner(System.in);

		System.out.print("money를 입력하세요 : ");
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		money = scanner.nextInt();

		System.out.println("money = " + money);
	}
	
	
	/**
	 * 동전의 수를 계산하는 함수 입니다.
	 */
	private static void calcMoney() {
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;

			// coinNum에 돈에서 코인 배열을 나눈 값을 저장합니다.
			coinNum = money / coinUnit[i];
			if(coin[i] - coinNum < 0) {
				// 코인i의 최대 개수만큼 금액을 감소시킵니다.
				money = remindMoney(money, coinUnit[i], coin[i]);
				// 코인i의 개수를 0으로 합니다.
				coin[i] = 5;
			} else {
				// 코인i의 개수만큼 금액을 감수시킵니다.
				money = remindMoney(money, coinUnit[i], coinNum);
				// 코인i의 남은 개수를 저장합니다.
				count[i] = coinNum;
				coin[i] = coin[i] - coinNum;
			}
		}
	}
	
	
	/**
	 * 
	 * @param money
	 * @param coinUnit
	 * @param coinNum
	 * @return
	 * 
	 * 남은 돈을 계산하는 메서드 입니다.
	 * 
	 */
	private static int remindMoney(int money, int coinUnit, int coinNum) {
		return money - (coinUnit * coinNum);
	}
	
	
	/**
	 * 돈이 남았는지를 판단하는 메서드 입니다.
	 */
	private static void judgeMoney() {
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다.");
		} else {
			printUse();
		}
	}


	/**
	 * 사용한 동전의 개수를 풀력하는 메서도 입니다.
	 */
	private static void printUse() {
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i] + "원 : " + count[i]);
		}
	}

	
	/**
	 * 남은 동전의 개수를 출력하는 메서드 입니다.
	 */
	private static void printRemind() {
		System.out.println("= 남은 동전의 개수 =");

		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i]);
		}
	}
	
	

}
