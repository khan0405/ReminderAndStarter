package jras.study.homework.day3;

import java.util.Scanner;

public class Exercise4_14_NumberMatchingGame {
	  
	public static void main(String[] args) {
		// 1~100 사이의 임의의 값을 얻어서 answer에 저장한다.
		int answer 	= (int) (Math.random() * 100 + 1);
			
		int input 	= 0;
		int count 	= 0;

		// 화면으로부터 사용자 입력을 받기 위해서 Scanner 클래스 사용
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요 : ");
			input = scanner.nextInt();
			
			if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if(input > answer) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다. \n시도횟수는 총 " + count + "번입니다.");
				break;
			}
		} while(true);
	}

}