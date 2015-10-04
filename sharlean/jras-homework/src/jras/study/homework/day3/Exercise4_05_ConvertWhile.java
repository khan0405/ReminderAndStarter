package jras.study.homework.day3;

public class Exercise4_05_ConvertWhile {
	public static void main(String[] args) {
		//예제 코드.
		//sample();
		
		//while문으로 변경한 코드.
		//convertSampleCode();
		
		//재사용 가능하게 작성하고, 리팩토링한 코드.
		printLineNumberStars(10);
	}

	/**
	 * 예제 문제에서 주어진 코드
	 * 이중 for문을 통해 *을 라인 갯수만큼 찍도록 한다. 
	 */
	private static void sample() {
		for(int i=0; i <= 10; i++) {
			for(int j=0; j<=i; j++) 
				System.out.print("*");
			System.out.println("");
		}
	}
	
	/**
	 * 예제 코드를 단순히 while문으로 변경한 코드.
	 * 동작은 sample()과 동일하다.
	 */
	private static void convertSampleCode() {
		int i = 0;
		
		while(i <= 10) {
			int j = 0;
			while(j <= i) {
				System.out.print("*");
				j++;
			}
			
			System.out.println("");
			i++;
		}
	}
	
	/**
	 * 리팩토링 후의 코드 1.
	 * maxPrintLine으로 넘어온 숫자만큼 printStar를 반복하도록 요청한다.
	 * 
	 * @param maxPrintLine
	 */
	private static void printLineNumberStars(int maxPrintLine) {
		int maxPrintStar = 0;
		
		while(maxPrintStar <= maxPrintLine) {
			printStar(maxPrintStar);
			
			maxPrintStar++;
		}
	}

	/**
	 * 리팩토링 후의 코드 2.
	 * maxPrintStar로 넘어온 숫자만큼 한 라인에 별을 출력한다.
	 * 
	 * ex) maxPrintStar로 넘어온 값이 5라면
	 *     한 줄에 5개의 *를 찍음. 
	 * 
	 * 단, maxPrintStar와 값이 동일하다면(마지막으로 찍는 별이라면) 출력 구문이 다음 라인으로 넘어가도록 한다.
	 * 메서드는 기본적으로 하나의 일만 하도록 작성하는 것이 좋지만, 간단히 삼항 연산자로 해결 가능한 구문이므로 포함해보았다.
	 * 
	 * @param maxPrintStar
	 */
	private static void printStar(int maxPrintStar) {
		int printStar = 0;
		
		while(printStar <= maxPrintStar) {
			System.out.print(printStar == maxPrintStar ? "*\n" : "*");
			printStar++;
		}
	}

}