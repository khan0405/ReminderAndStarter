package Study01;

import java.util.Random;

public class Question_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int answer = (int) (Math.random()*100) ;
		int input = 0;
		int count = 0;
		java.util.Scanner s = new java.util.Scanner(System.in);
		do{
			count++;
			System.out.println("1과 100 사이의 값을 입력해주세요");
			input = s.nextInt();
			if(input == answer){
				System.out.println("맞췄습니다");
				System.out.println("시도 횟수는 "+ count + " 입니다.");
				break;
			}else if(input > answer){
				System.out.println("더 작은 수를 입력 해주세요");
			}else if(input < answer){
				System.out.println("더 큰 수를 입력 해주세요");
			}
		}
		while(true);
	}
}
