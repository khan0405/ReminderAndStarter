package jras.study.exercise;

/**
 * 방정식 2x + 4y = 10 의 모든 해를 구하는 예제
 * Created by KHAN on 2015-10-03.
 */
public class Exercise4_8 {

	private static final int MIN_VALUE = 0;
	private static final int MAX_VALUE = 10;

	public static void main(String[] args) {
		findSolution();
	}

	static void findSolution() {
		for(int x = MIN_VALUE; x <= MAX_VALUE; x++) {
			for (int y = MIN_VALUE; y <= MAX_VALUE; y++) {
				if (isSolution(x, y)) {
					printSolution(x, y);
				}
			}
		}
	}

	static boolean isSolution(int x, int y) {
		return (2 * x) + (4 * y) == 10;
	}

	static void printSolution(int x, int y) {
		System.out.println(String.format("x=%s, y=%s", x, y));
	}
}
