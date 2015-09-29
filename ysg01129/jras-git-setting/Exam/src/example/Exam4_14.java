package example;

import java.awt.Container;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Exam4_14 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		original();
		remake();
		

	}
	
	private static void original() {
		int answer = (int) (Math.random() * 100)  +1;
		int input = 0;
		int count = 0;
		
		Scanner s = new Scanner(System.in);
		
		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = s.nextInt();
			
			if(input == answer) {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 " + count + "번 입니다.");
				break;
			} else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
			} else {
				System.out.println("더 작은 수를 입력하세요.");
			}
		} while(true);
				
	}
	
	private static void remake() {
		int answer = (int) (Math.random() * 100) + 1;
		int input = 0;
		int count = 0;
		int min = 1;
		int max = 100;
		
		Scanner s = new Scanner(System.in);
		
		while(true) {
			System.out.print(min + "과 " + max + "사이의 값을 입력하세요 : ");
			count++;
			input = s.nextInt();
			
			if(input == answer) {
				System.out.println("정답입니다.");
				System.out.println("시도 횟수는 " + count + "번 입니다.");
				break;
			} else if(input < answer) {
				System.out.println("더 큰 수를 입력하세요.");
				min = input;
			} else {
				System.out.println("더 작은수를 입력하세요.");
				max = input;
			}
			
		}
	}
}
