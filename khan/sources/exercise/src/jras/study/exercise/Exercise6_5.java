package jras.study.exercise;

/**
 * Created by KHAN on 2015-10-09.
 */
public class Exercise6_5 {
	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76);
		System.out.println(s.info());
	}
	static class Student {
		String name;
		int ban;
		int no;
		int kor;
		int eng;
		int math;

		public Student(String name, int ban, int no, int kor, int eng, int math) {
			this.name = name;
			this.ban = ban;
			this.no = no;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}

		public int getTotal() {
			return kor + eng + math;
		}

		public float getAverage() {
			float result = 0f;
			result = getTotal() / 3f;
			result = Math.round(result * 10f) / 10f;
			return result;
		}

		public String info() {
			return name + "," + ban + "," + no + "," + kor  + "," + eng  + "," + math  + "," + getTotal()  + "," + getAverage();
		}
	}
}
