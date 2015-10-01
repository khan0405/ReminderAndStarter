package jras.study.homework;

import java.util.ArrayList;
import java.util.List;

public class OneToTenAccumulateSum {
	
	public static void main(String[] args) {
		new OneToTenAccumulateSum().doAccumulateSum();
	}
	
	private Integer totalAccumulateSum = 0;
	
	public void doAccumulateSum() {
		OneToTenAccumulateIterator oneToTenIterator = new OneToTenAccumulateIterator();
		Calculator calculator = new Calculator();
		
		while(oneToTenIterator.isIterate()) {
			Integer[] nextNumberUntilNow = oneToTenIterator.nextNumberUntilNow();
			totalAccumulateSum += calculator.sum(nextNumberUntilNow);
			
			printUntiNumber(nextNumberUntilNow);
		}
		
		printTotal();
	}
	
	private void printUntiNumber(Integer[] nextNumberUntilNow) {
		StringBuilder numberString = new StringBuilder();
		for(Integer nextNumber : nextNumberUntilNow) {
			numberString.append(nextNumber).append(", ");
		}
		numberString.delete(numberString.length() - 2, numberString.length());
		
		System.out.printf("total is to be a %d => first to current number is %s\n", totalAccumulateSum, numberString.toString());
	}
	
	private void printTotal() {
		System.out.printf("Total accumulate sum is %d", totalAccumulateSum);
	}
	
	class OneToTenAccumulateIterator {
		
		private final Integer[] ONE_TO_TEN_NUMBER = new Integer[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		private int nextIndex;
		
		public OneToTenAccumulateIterator() {
			nextIndex = 0;
		}
		
		public boolean isIterate() {
			return nextIndex < ONE_TO_TEN_NUMBER.length;
		}
		
		public Integer[] nextNumberUntilNow() {
			Integer currentNumber = ONE_TO_TEN_NUMBER[nextIndex];
			List<Integer> accumulateNumber = new ArrayList<>();
			
			accumulateUntil(currentNumber, accumulateNumber);
			countUpNextIndex();
			
			return accumulateNumber.toArray(new Integer[]{});
		}
		
		private void countUpNextIndex() {
			nextIndex++;
		}
		
		private void accumulateUntil(Integer currentNumber, List<Integer> accumulateNumber) {
			for(int i = 0; i < currentNumber; i++) {
				accumulateNumber.add(ONE_TO_TEN_NUMBER[i]);
			}
		}
	}
	
	class Calculator {
		public Integer sum(Integer[] numbers) {
			Integer sum = 0;
			for(Integer number : numbers) {
				sum += number;
			}
			return sum;
		}
	}
}
