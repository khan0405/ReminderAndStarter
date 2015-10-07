package jras.study.homework.day4;

import java.util.HashSet;
import java.util.Iterator;

/**
 * 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다. 
 * 알맞은 코드를 넣어서 프로그램을 완성하시오.
 * 
 * 
 * @author Yunseong
 *
 */
public class Exercise5_05 {
	public static void main(String[] args) {
		//배열을 활용한 코드 작성
		printDigits(3);
		
		//중복값을 넣을 수 없는 Set의 속성을 이용한 코드 작성
		printDigitsWithSet(3);
	}

	/**
	 * 
	 * @param numberDigits
	 */
	private static void printDigitsWithSet(int numberDigits) {
		HashSet<Integer> randomNumberSet = new HashSet<Integer>();
		
		while(randomNumberSet.size() < 3) {
			randomNumberSet.add(randomNum(10));
		}
		
		System.out.println(attachNumberToMessage(numberDigits, randomNumberSet));
	}

	/**
	 * 
	 * @param numberDigits
	 * @param randomNumberSet
	 * @return
	 */
	private static String attachNumberToMessage(int numberDigits, HashSet<Integer> randomNumberSet) {
		Iterator<Integer> numbersIt = randomNumberSet.iterator();
		
		String result = "1~9 사이에서 겹치지 않는 임의의 숫자[자릿수 : " + numberDigits + "] : ";
		
		while(numbersIt.hasNext()) {
			result += numbersIt.next();
		}
		
		return result;
	}

	/**
	 * 
	 * @param numberDigits
	 */
	private static void printDigits(int numberDigits) {
		int[] numbers = randomNumberGenerator(numberDigits);
		
		System.out.println("1~9 사이에서 겹치지 않는 임의의 숫자[자릿수 : " + numberDigits + "] : " + numbers[0] + numbers[1] + numbers[2]);
	}

	/**
	 * 
	 * @param numberDigits
	 * @return
	 */
	private static int[] randomNumberGenerator(int numberDigits) {
		int[] numbers = new int[numberDigits];
		
		for(int i = 0; i < numberDigits; i++) {
			int random = -1;
			
			do {
				random = randomNum(10);
			} while(isDuplicate(random, numbers));
			
			numbers[i] = random;
		}
		
		return numbers;
	}

	/**
	 * 
	 * @param maxNum
	 * @return
	 */
	private static int randomNum(int maxNum) {
		int random = (int) (Math.random() * maxNum);
		
		return random == 0 ? randomNum(maxNum) : random;
	}

	private static boolean isDuplicate(int random, int[] numbers) {
		for(int num : numbers) {
			if(random == num) { return true; }
		}
		
		return false;
	}
}
