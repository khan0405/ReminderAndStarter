package jras.study.exercise;

/**
 * 숫자 맞추기
 * Created by KHAN on 2015-10-01.
 */
public class Exercise4_14 {
	public static void main(String[] args) {
		// 1~100사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100 + 1); // 1번 블락
		int input = 0; // 사용자입력을 저장할 공간
		int count = 0; // 시도횟수를 세기위한 변수

		// 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
		java.util.Scanner s = new java.util.Scanner(System.in);

		System.out.println("answer:" + answer);
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = s.nextInt(); // 입력받은 값을 변수 input에 저장한다.

			// 2번 블락
			if (input == answer) {
				System.out.println(String.format("맞췄습니다.\n시도횟수는 %s번입니다.", count));
				break;
			}
			else {
				String result = (input < answer) ? "큰" : "작은";
				System.out.println(String.format("더 %s 수를 입력하세요.", result));
			}
			// 2번 블락 끝
		} while (true); // 무한반복문 } // end of main
	} // end of class HighLow
}