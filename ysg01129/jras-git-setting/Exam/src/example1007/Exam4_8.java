package example1007;
/**
 * 주어진 식의 올바른 값을 찾는 프로그램입니다.
 * 
 * @author HunJin
 *
 */
public class Exam4_8 {
	
	final int RESULT_NUMBER = 10;
	final static int MAX_NUMBER = 10;
	
	public static void main(String[] args) {
		
		Exam4_8 exam4_8 = new Exam4_8();
		exam4_8.findX(MAX_NUMBER);
		
	}
	
	/**
	 * 0부터 1씩 증가시켜 x 값을 파라미터로 넘깁니다.
	 * 
	 * @param maxNum
	 */
	private void findX(int maxNum) {
		for(int x=0; x<=maxNum; x++) {
			findY(x, maxNum);
		}
	}
	
	/**
	 * y값 역시 0부터 1씩 증가시킵니다.
	 * x값과 y값을 같이 파라미터로 넘깁니다.
	 * 
	 * @param x
	 * @param maxNum
	 */
	private void findY(int x, int maxNum) {
		for(int y=0; y<=maxNum; y++) {
			entrance(x, y);
		}
	}
	
	/**
	 * x와 y값을 대입 한 값 sum을 구합니다.
	 * sum이 자신이 원하는 값이 맞는지 체크를 위해 파라미터로 넘깁니다.
	 * 
	 * @param x
	 * @param y
	 */
	private void entrance(int x, int y) {
		int sum = 2*x + 4*y;
		if(isMatching(sum)) {
			System.out.println("x값은 : " + x + " y값은 : " + y + " 입니다.");
		}
	}
	
	/**
	 * 자신이 원하는 값이 맞는지를 체크 합니다.
	 * 
	 * @param sum
	 * @return
	 */
	private boolean isMatching(int sum) {
		if(sum == RESULT_NUMBER) {
			return true;
		} else {
			return false;
		}
	}

}
