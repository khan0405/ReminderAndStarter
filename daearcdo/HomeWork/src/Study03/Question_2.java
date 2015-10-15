package Study03;

public class Question_2 {

	public static void main(String[] args) {
		
		Question_1 Student = new Question_1();
		Student.name ="홍길동";
		Student.ban = 1;
		Student.no = 1;
		Student.kor = 100;
		Student.eng = 60;
		Student.math = 76;
		
		
		System.out.println("이름 : " +Student.name);
		System.out.println("총점 : " + Student.getTotal());
		System.out.println("평균 : " + Student.getAverage());
		
	}
}
