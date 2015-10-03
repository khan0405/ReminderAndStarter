package jras.study.exercise;

/**
 * 1+(1+2)+(1+2+3)+(1+2+3+4)+....+(1+2+3+...+10)의 결과를 계산하는 예제
 * Created by KHAN on 2015-09-30.
 */
public class Exercise4_3 {

	public static void main(String[] args) {
		Exercise4_3 exercise = new Exercise4_3();
		exercise.doWork();
	}

	/**
	 * 1+(1+2)+(1+2+3)+(1+2+3+4)+....+(1+2+3+...+10)의 결과를 계산합니다.
	 */
	public void doWork() {
		int minNum = 1;
		int maxNum = 10;
		int result = calculate(minNum, maxNum, true);
		System.out.println(String.format("%s부터 %s의 합은 %s 입니다.", minNum, maxNum, result));
	}

	/**
	 * n+(n+(n+1))+(n+(n+1)+(n+2))+....+(n+(n+1)+(n+2)+...+maxValue)의 결과를 계산한다.
	 * @param minNum 처음에 시작할 숫자
	 * @param maxNum 마지막 숫자
	 * @param isMainCalculate 메인 계산인지, 서브 계산인지의 여부
	 * @return 모든 숫자의 합
	 */
	public int calculate(int minNum, int maxNum, boolean isMainCalculate) {
		int result = 0;
		for (int i = minNum; i <= maxNum; i++) {
			int value = i;
			if (isMainCalculate) {
				value = calculate(minNum, i, false);
			}
			result += value;
		}
		return result;
	}
}
