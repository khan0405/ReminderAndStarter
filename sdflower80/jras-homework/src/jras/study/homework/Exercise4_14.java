package jras.study.homework;

import java.util.Random;
import java.util.Scanner;

public class Exercise4_14 {
	public static void main(String[] args) {
		Random r = new Random();
		int answer = r.nextInt(100);
		int input = 0;
		int count = 0;
		
		Scanner s = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 :");
			input = s.nextInt();
			
			if (input == answer) {
				System.out.printf("맞췄습니다. 정답은 %d 였습니다.\n", answer);
				System.out.printf("시도 횟수는 %d번입니다.\n", count);
				break;
			} else {
				if (input < answer) {
					System.out.println("더 큰 수를 입력하세요.");
				} else if (input > answer) {
					System.out.println("더 작은 수를 입력하세요.");
				}
			}
			
		} while(true);
	}
}
