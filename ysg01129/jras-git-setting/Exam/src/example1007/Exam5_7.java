package example1007;

import java.util.Scanner;

/**
 * 남은 동전의 개수를 구하는 프로그램 입니다.
 * 
 * @author HunJin
 *
 */
public class Exam5_7 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		int money = scanner.nextInt();
		
		System.out.println("money = " + money);
		
		int[] coinUnit = {500, 100, 50, 10 };
		int[] coin     = {5, 5, 5, 5};
		
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;
		
			// coinNum에 돈에서 코인 배열을 나눈 값을 저장합니다.
			coinNum = money / coinUnit[i];
			if(coin[i] - coinNum < 0) {
				// 코인i의 최대 개수만큼 금액을 감소시킵니다.
				money = money - (coinUnit[i] * coin[i]);
				// 코인i의 개수를 0으로 합니다.
				coin[i] = 0;
			} else {
				// 코인i의 개수만큼 금액을 감수시킵니다.
				money = money - (coinUnit[i] * coinNum);
				// 코인i의 남은 개수를 저장합니다.
				coin[i] = coin[i] - coinNum;
			}
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다.");
			System.exit(0);
		}
		
		System.out.println("= 남은 동전의 개수 =");
		
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i] + "원 : " + coin[i]);
		}
	}
}
