package jras.study.homework.day4;

import java.util.List;

/**
 * 방정식 2x+4y=10의 모든 해를 구하시오. 
 * 단, x와 y는 정수이고 각각의 범위는 0<=x<=10, 0<=y<=10 이다.
 * 
 * [실행 결과]
 * x=1, y=2
 * x=3, y=1
 * x=5, y=0
 * 
 * @author Yunseong
 */
public class Exercise4_08 {
	public static void main(String[] args) {
		int[] rangeX = makeRangeToArray(0, 10);
		int[] rangeY = makeRangeToArray(0, 10);
		
		final int WEIGHT_X = 2;
		final int WEIGHT_Y = 4;
				
		final int RIGHT_VAL = 10;
		
		answersFindAll(rangeX, rangeY, WEIGHT_X, WEIGHT_Y, RIGHT_VAL);
	}

	/**
	 * 
	 * @param rangeX
	 * @param rangeY
	 * @param weightX
	 * @param weightY
	 * @param rightVal
	 */
	private static void answersFindAll(int[] rangeX, int[] rangeY, int weightX, int weightY, int rightVal) {
		
		for(int x = 0; x < rangeX.length; x++) {
			for(int y = 0; y < rangeY.length; y++) {
				if(isAnswer(weightX, weightY, rightVal, x, y)) {
					printAnswer(x, y);
				}
			}
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	private static void printAnswer(int x, int y) {
		System.out.println("x=" + x + ", y=" + y);
	}

	/**
	 * 
	 * @param weightX
	 * @param weightY
	 * @param rightVal
	 * @param x
	 * @param y
	 * @return
	 */
	private static boolean isAnswer(int weightX, int weightY, int rightVal, int x, int y) {
		return x * weightX + y * weightY == rightVal;
	}

	/**
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private static int[] makeRangeToArray(int start, int end) {
		int[] range = new int[end - start + 1];
		
		for(int i = 0; i < range.length; i++) {
			range[i] = start + i;
		}
		
		return range;
	}
}
