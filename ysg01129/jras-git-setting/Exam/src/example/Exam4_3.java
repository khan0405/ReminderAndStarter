package example;

public class Exam4_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum = 0;
		
		for(int i=1;i<=10;i++) {
			System.out.print("(");
			for(int j=1;j<=i;j++) {
				sum += j;
				System.out.print(j);
				if(j<i) {
					System.out.print(" + ");
				}
			}
			System.out.print(")");
			if(i<10) {
				System.out.print(" + ");
			}
		}
		
		System.out.println();
		System.out.println("값 : " + sum);
	}
}
