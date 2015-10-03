package jras.study.exercise;

/**
 * For 문을 while문으로 변경한 코드
 * Created by KHAN on 2015-10-01.
 */
public class Exercise4_5 {
	public static void main(String[] args) {
		exCode();
		convertExCode();
	}

	/**
	 * 예제 코드입니다.
	 */
	public static void exCode() {
		for (int i=0; i<=10; i++) {
			for (int j=0; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

	/**
	 * while로 변경한 코드입니다.
	 */
	public static void convertExCode() {
		int i = -1;
		while(++i <= 10) {
			int j = 0;
			while(j++ <= i) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}