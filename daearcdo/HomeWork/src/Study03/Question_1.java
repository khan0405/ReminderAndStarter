package Study03;

import java.awt.geom.FlatteningPathIterator;

public class Question_1 {

	String name; //학생이
	int ban; // 반
	int no;  // 번호
	int kor; // 국어점수
	int eng; // 영어
	int math; // 수학
	
	
	public int getTotal(){
		
		
		
		return kor + eng + math;
	}
	
	public float getAverage(){
		
		float sum = (kor + eng + math) / 3;
		
		return Math.round((sum*100)/100.0);
	}
	
	public void info(String name, int ban, int no, int kor, int eng, int math){
		
		
		

	}
}
