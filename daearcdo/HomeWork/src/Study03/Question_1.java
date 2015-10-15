package Study03;

import java.awt.geom.FlatteningPathIterator;

public class Question_1 {

	String name; //학생이
	int ban; // 반
	int no;  // 번호
	int kor; // 국어점수
	int eng; // 영어
	int math; // 수학
	
	public Question_1(){
		
	}
	
	public Question_1(String name,int ban,int no,int kor,int eng, int math){
		
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
				
		
	}
	
	public void info(){
		
		System.out.println(name +"," +ban +"," + no +"," +kor+"," +eng+"," +math );
	}
	
	public float getTotal(){
		
		
		
		return (float) kor + eng + math;
	}
	
	public float getAverage(){
		
		float sum = (float) (kor + eng + math) / 3f;
		
		return Math.round((sum*10))/10f;
	}
	
	public void info(String name, int ban, int no, int kor, int eng, int math){
		
		
		

	}
}
