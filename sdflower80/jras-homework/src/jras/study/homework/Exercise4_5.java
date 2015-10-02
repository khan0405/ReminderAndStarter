package jras.study.homework;

public class Exercise4_5 {
	public static void main(String[] args) {
		new Exercise4_5().doDoubleWhileLoop();
	}
	
	public void doDoubleForLoop() {
		for(int i = 0; i <= 10; i++) {
			for(int j = 0; j <= i; j++) 
				System.out.print("*");
			System.out.println();
		}
	}
	
	public void doDoubleWhileLoop() {
		OneToTenIterator oneToTenIterator = new OneToTenIterator();
		while(oneToTenIterator.isIterate()) {
			Integer nextNumber = oneToTenIterator.nextNumber();
			UntilLastIterator untilLastIterator = new UntilLastIterator(nextNumber);
			while(untilLastIterator.isUntilLast()) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	class OneToTenIterator {
		private final Integer[] ONE_TO_TEN_NUMBER = new Integer[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		
		private int nextIndex;
		
		public OneToTenIterator() {
			nextIndex = 0;
		}
		
		public boolean isIterate() {
			return nextIndex < ONE_TO_TEN_NUMBER.length;
		}
		
		public Integer nextNumber() {
			Integer currentNumber = ONE_TO_TEN_NUMBER[nextIndex];
			countUpNextIndex();
			return currentNumber;
		}
		
		private void countUpNextIndex() {
			nextIndex++;
		}
	}
	
	class UntilLastIterator {
		private Integer lastNumber;
		private Integer nextIndex;
		
		public UntilLastIterator(Integer lastNumber) {
			this.lastNumber = lastNumber;
			this.nextIndex = 0;
		}
		
		public Integer next() {
			return nextIndex;
		}
		
		public boolean isUntilLast() {
			return nextIndex++ < lastNumber;
		}
	}
}
