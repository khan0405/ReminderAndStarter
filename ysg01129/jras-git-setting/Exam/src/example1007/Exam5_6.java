package example1007;
/**
 * 거스름돈을 계산하는 프로그램입니다.
 * 
 * @author HunJin
 *
 */
public class Exam5_6 {

	static int[] coinUnit = {500, 100, 50, 10};
	static int[] count = new int[coinUnit.length];
	static int money = 2680;
	
	public static void main(String[] args) {
		// 큰 금액의 동전을 우선적으로 거슬러 줘야한다.

		System.out.println("money = " + money);
		
		minusCalc();  // 감산을 이용한 방법입니다.
//		divCalc();    // 나머지와 나눗셈을 이용한 방법입니다.
		print();
	}
	
	/**
	 * 감산을 이용한 방법입니다.
	 * 코인 배열의 값이 금액보다 작으면 금액을 감소시키고
	 * 카운트를 증가시킵니다.
	 */
	private static void minusCalc() {
		for(int i=0;i<coinUnit.length;i++) {
			count[i] = 0; // count으 값을 0으로 초기화 합니다.
			while(coinUnit[i] <= money) { // coinUnit[i]의 값이 금액보다 작으면
				money = money - coinUnit[i];  // 금액을 coinUnit[i]만큼 감소 시킵니다.
				count[i]++;
			}
		}
	}
	
	/**
	 * 나누기와 나머지를 이용한 방법입니다.
	 * 카운트에 돈에서 코인 배열 값만큼 나눈 값을 저장하고
	 * 나머지 값은 돈에 저장시킵니다.
	 */
	private static void divCalc() {
		for(int i=0;i<coinUnit.length;i++) {
			count[i] = 0; // count를 0으로 초기화 합니다.
			count[i] = money / coinUnit[i];
			money = money % coinUnit[i];
		}
	}
	
	/**
	 * 출력 함수 입니다.
	 */
	private static void print() {
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i] + "원 : " + count[i]);
		}
	}
}
