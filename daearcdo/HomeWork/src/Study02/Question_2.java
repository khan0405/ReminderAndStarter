package Study02;

import java.util.Arrays;

public class Question_2 {
	public static void main(String[] args) {

		int[] ballarr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] ball = new int[3];

		for (int x = 0; x < 20; x++) {

			int i = (int) (Math.random() * ballarr.length);
			int j = (int) (Math.random() * ballarr.length);
			int tmp = 0;

			System.out.println("위치 옴기기 전 : " + Arrays.toString(ballarr));

			System.out.println("위치 교환 : " + ballarr[i] + " / " + ballarr[j]);
			if(ballarr[i] == ballarr[j]){
				System.out.println("교환 값이 동일 합니다.");
			}
			tmp = ballarr[i];
			ballarr[i] = ballarr[j];
			ballarr[j] = tmp;

			System.out.println("위치 옴기기 후 : " + Arrays.toString(ballarr));

		}
		
		
		//ball = ballarr;
		ball[0] = ballarr[0];
		ball[1] = ballarr[1];
		ball[2] = ballarr[2];
		
		
		for(int i=0;i<ball.length;i++){
			System.out.print(ball[i]);
			
		}
		
		

	}

}
