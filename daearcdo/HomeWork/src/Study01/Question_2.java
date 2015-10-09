
package Study01;

public class Question_2 {

	public static void main(String[] args) {

		int Sum = 0;
		int i = 1;

		while (Sum <= 100) {
			int aa = 0;
			aa = (i % 2);
			System.out.println("현재 값 " + "i 값 " + i + " / " + aa);

			switch (aa) {

			case 0:
				Sum += -i;
				break;

			case 1:
				Sum += i;
				break;
			}
			i++;
		}
		System.out.println("i의 갯수 " + i);
		System.out.println("총합 " + Sum);
	}

}
// 총 202번이 돌아야 101이란 값을 얻을수 있다. 
