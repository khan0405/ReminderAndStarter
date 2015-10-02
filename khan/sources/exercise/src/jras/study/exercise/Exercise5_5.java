package jras.study.exercise;

/**
 * 1과 9 사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 예제
 * Created by KHAN on 2015-10-03.
 */
public class Exercise5_5 {
	public static void main(String[] args) {
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];

		// 배열 ballArr의 임의의 요소 2개를 골라서 위치를 바꾼다. 20번 반복
		for (int x = 0; x < 20; x++) {
			int i = (int) (Math.random() * ballArr.length);
			int j = (int) (Math.random() * ballArr.length);
			int tmp = 0;

			// block 1
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
			// block 1 끝

			// 아래의 방법으로도 자리를 바꿀 수 있다.
			// block 1
//			if (ballArr[i] != ballArr[j]) {
//				ballArr[i] ^= ballArr[j];
//				ballArr[j] ^= ballArr[i];
//				ballArr[i] ^= ballArr[j];
//			}
			// block 1 끝
		}

		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
		// block 2
		for (int i = 0; i < 3; i++) {
			ball3[i] = ballArr[i];
		}
		// block 2 끝

		for (int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	} // end of main
} // end of class
