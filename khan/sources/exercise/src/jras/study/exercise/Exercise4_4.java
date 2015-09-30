package jras.study.exercise;

/**
 * 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상이 되는지 구하는 예재
 * Created by KHAN on 2015-09-30.
 */
public class Exercise4_4 {
	public static void main(String[] args) {
		Exercise4_4 exercise = new Exercise4_4();
		exercise.doWork();
	}

	/**
	 * 1+(-2)+3+(-4)+... 를 계산하여 100이 넘을 때의 숫자를 계산합니다.
	 */
	public void doWork() {
		int startValue = 1;
		int maxSumValue = 10;
		int result = calculateResult(startValue, maxSumValue);
		System.out.println(String.format("1+(-2)+3+(-4)+... 과 같은 식으로 %s까지 계산해야 %s이(가) 넘게 됩니다.", result, maxSumValue));
	}

	/**
	 * 1+(-2)+3+(-4)+... 의 패턴대로 계산하여 maxSumValue를 넘을 때의 값을 반환합니다.
	 * @param startValue 시작 숫자
	 * @param maxSumValue 총합 제한 숫자
	 * @return 정해진 패턴대로 더하여 정해진 총합 제한숫자를 넘는 경우 마지막 숫자를 반환
	 */
	public int calculateResult(int startValue, int maxSumValue) {
		int sum = 0;
		boolean odd = false;
		int value;
		for (value = startValue; sum < maxSumValue; value++) {
			odd = !odd;
			sum += odd ? value : -value;
		}
		// While문으로 바꾸면 다음과 같음
//		while(sum < maxSumValue) {
//			odd = !odd;
//			sum += odd ? value : -value;
//			value++;
//		}
		return value - 1;
	}
}
