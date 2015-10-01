package jras.study.homework;

public class PlusMinusForSumUntilOneHundred {
	
	public static void main(String[] args) {
		new PlusMinusForSumUntilOneHundred()
			.doPlusMinusForSumUntilOneHundred();
	}
	
	private SequenceIterator sequenceIterator;
	private Integer lastNumberWhenOverOneHundred;
	
	public PlusMinusForSumUntilOneHundred() {
		sequenceIterator = new SequenceIterator();
		lastNumberWhenOverOneHundred = 0;
	}
	
	public void doPlusMinusForSumUntilOneHundred() {
		Integer totalSum = 0;
		while(sequenceIterator.stillRunning()) {
			Integer nextSeq = sequenceIterator.nextSeq();
			totalSum += plusMinusConvert(nextSeq);
			judgeWhetherRunning(totalSum, nextSeq);
			
			if ((nextSeq % 20) == 0) {
				try {
					System.out.printf("sleep.. nextSeq is %d \n", nextSeq);
					Thread.sleep(1000);
				} catch (Exception ex) {
					throw new IllegalStateException("Thread Exception");
				}
			}
		}
		
		System.out.printf("The last number is %d and totalSum is %d. \n", lastNumberWhenOverOneHundred, totalSum);
	}
	
	private Integer plusMinusConvert(Integer num) {
		return (num % 2) == 0 ? -num : num;
	}
	
	private void judgeWhetherRunning(Integer totalSum, Integer nextSeq) {
		if (totalSum >= 100) {
			lastNumberWhenOverOneHundred = nextSeq;
			sequenceIterator.stop();
		}
	}
	
	class SequenceIterator {
		private Integer seq;
		private boolean stillRunning;
		
		public SequenceIterator() {
			stillRunning = true;
			seq = 0;
		}
		
		public boolean stillRunning() {
			return stillRunning;
		}
		
		public Integer nextSeq() {
			return ++seq;
		}
		
		public void stop() {
			stillRunning = false;
		}
	}
	
	class PlusMinusCalculator {
		public void sum(Integer num) {
			Integer sum = 0;
			
		}
	}
}
