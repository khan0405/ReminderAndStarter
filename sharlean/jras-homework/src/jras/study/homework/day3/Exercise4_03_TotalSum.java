package jras.study.homework.day3;

public class Exercise4_03_TotalSum {

	public static void main(String[] args) {
		//재사용 가능하도록 리팩토링한 코드 작성.
		printSum(10);
	} 
 
	/**
	 * totalSumCalculator 메서드가 구한 총합을 출력한다.
	 * 
	 * @param maxNum
	 */
	private static void printSum(int maxNum) {
		System.out.println("1부터 " + maxNum + "까지의 합은 " + totalSumCalculator(maxNum) + "입니다.");
	}

	/**
	 * currentSum에서 구한 합을 모두 더해서 리턴한다.
	 * 
	 * @param maxNum
	 * @return
	 */
	private static int totalSumCalculator(int maxNum) {
		int totalSum = 0;
		
		for(int currentNum = 1; currentNum <= maxNum ; currentNum++) {
			totalSum += currentSum(currentNum);
		}
		
		return totalSum;
	}

	/**
	 * 1부터 maxNum까지 1씩 증가한 값을 모두 더한다음 리턴한다.
	 * 
	 * ex) maxNum이 3이라면
	 * 	   1 + 2 + 3 = 6을 리턴함
	 * 
	 * @param maxNum
	 * @return
	 */
	private static int currentSum(int maxNum) {
		int current = 0;
		
		for(int startNum = 1; startNum <= maxNum; startNum++) {
			current += startNum;
		}
		
		return current;
	}

}