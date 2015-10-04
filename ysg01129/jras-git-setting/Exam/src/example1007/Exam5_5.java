
package example1007;

/**
 * 중복되지 않은 3자리 숫자를 만들어내는 프로그램입니다.
 * 
 * @author HunJin
 *
 */

public class Exam5_5 {

	static int[] ballArr = {1,2,3,4,5,6,7,8,9};
	static int[] ball3 = new int[3];	
	private static final int MAX_NUMBER = 10;

	public static void main(String[] args) {
		
		// 배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복		
		shake(MAX_NUMBER);
		
		for(int i=0;i<3;i++) {
			ball3[i] = ballArr[i];
		}
		
		for(int i=0;i<ball3.length;i++) {
			System.out.print(ball3[i] + " ");
		}
	}
	
	
	/**
	 * 받아온 숫자만큼 값을 섞습니다.
	 * 
	 * @param maxNum
	 */
	private static void shake(int maxNum) {
		for(int i=0;i<maxNum;i++) {
			int x = getRandomNumber();
			int y = getRandomNumber();
			int tmp = 0;
			
			tmp = ballArr[x];
			ballArr[x] = ballArr[y];
			ballArr[y] = tmp;
			
		}
	}
	
	
	/**
	 * 랜덤값을 반환합니다.
	 * 
	 * @return
	 */
	private static int getRandomNumber() {
		
		return (int)(Math.random() * ballArr.length);
	}
}
