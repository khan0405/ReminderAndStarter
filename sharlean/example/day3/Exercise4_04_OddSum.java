package study.day3;

public class Exercise4_04_OddSum {
	public static void main(String[] args) {
		//재사용 가능하도록 리팩토링한 코드 작성.
		oddSum(100);
	}
  
	/**
	 * 반복문을 통해 1부터 숫자를 증가시켜 evenMinusNum에서 넘어온 값을 합산한다.
	 * 
	 * 반복문을 계속 진행 중에 isOverflow가 true가 될 경우
	 * 계산을 멈추고 printResult를 호출한다.
	 *   
	 * @param limit
	 */
	private static void oddSum(int limit) {
		int total = 0;
		int lastNum = 0;
		
		for(int i = 1; i < Integer.MAX_VALUE; i++) {
			total += evenMinusNum(i);
			
			if(isOverflow(total, limit)) {
				lastNum = i;
				break;
			}
		}
		
		printResult(lastNum, total);
	}

	/**
	 * number로 넘어온 값이 짝수면 음수로 값을 리턴하고,
	 * 홀수면 그대로 리턴한다.
	 * 
	 * ex) 2가 넘어온 경우
	 *    -2를 리턴함.
	 *    
	 * @param number
	 * @return
	 */
	private static int evenMinusNum(int number) {
		if(number % 2 == 0) { return -number; } 
		else                { return  number; }
	}

	/**
	 * 마지막으로 더한 숫자값과 전체 합을 출력한다.
	 * 
	 * @param lastNum
	 * @param total
	 */
	private static void printResult(int lastNum, int total) {
		System.out.println(lastNum + "까지 더해야 총합이 " + total + "이 됩니다.");
	}

	/**
	 * total값이 limit값과 같거나 초과했는지 확인한다.
	 * 같거나 초과한 경우 true를 리턴한다.
	 * 
	 * ex) limit가 100이고, total이 101인 경우
	 *     true를 리턴함. 
	 * 
	 * @param total
	 * @param limit
	 * @return
	 */
	private static boolean isOverflow(int total, int limit) {
		return total >= limit;
	}
}
