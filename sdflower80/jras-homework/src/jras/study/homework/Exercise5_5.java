package jras.study.homework;

import java.util.ArrayList;
import java.util.List;

public class Exercise5_5 {
	public static void main(String[] args) {
		int[] ballArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] ball3 = new int[3];
		
		for(int x = 0; x < 20; x++) {
			int i = (int)(Math.random() * ballArr.length);
			int j = (int)(Math.random() * ballArr.length);
			int tmp = 0;
			
			// swap
			tmp = ballArr[i];
			ballArr[i] = ballArr[j];
			ballArr[j] = tmp;
		}
		
		RandomBallGrabber randomBallGrabber = new RandomBallGrabber(ballArr);
		for(int x = 0; x < ball3.length; x++) {
			ball3[x] = randomBallGrabber.grabRandomBall();
		}
		
		for(int i = 0; i < ball3.length; i++) {
			System.out.print(ball3[i]);
		}
	}
	
	public static class RandomBallGrabber {
		private int[] ballCapacityArray;
		private List<Integer> randomHistory;
		public RandomBallGrabber(int[] ballCapacityArray) {
			this.ballCapacityArray = ballCapacityArray;
			this.randomHistory = new ArrayList<>();
		}
		
		public int grabRandomBall() {
			int randomIndex = (int)(Math.random() * 10);
			int randomBall = -1;
			for(int i = 0; i < ballCapacityArray.length; i++) {
				if (!this.randomHistory.contains(randomIndex)) {
					randomBall = ballCapacityArray[randomIndex];
					this.randomHistory.add(randomIndex);
				}
			}
			if (randomBall == -1) {
				throw new IllegalStateException("더이상 가져올 수 있는 RandomBall 이 없음!");
			}
			
			return randomBall;
		}
	}
}
