package example1014;

/**
 * 
 * Student 클래스 입니다. 값들을 얻어와 처리를 하도록 만들었습니다.
 * 
 * @author HunJin
 *
 */

public class Student {

	public String name;
	public int ban;
	public int no;
	public int kor;
	public int eng;
	public int math;
	private int total;
	private float average;

	/**
	 * 메서드 오버로딩을 하여 4번 문제와 5번 문제를 동시에 풀 수 있도록 하였습니다.
	 */
	Student() {

	}

	/**
	 * 기본적으로 처음 실행이 되면 매개변수가 있을 경우 다음과 같은 메서드가 실행됩니다.
	 * 
	 * @param name
	 * @param ban
	 * @param no
	 * @param kor
	 * @param eng
	 * @param math
	 */
	Student(String name, int ban, int no, int kor, int eng, int math) {
		setName(name); // 이름 입력
		setBan(ban); // 반 입력
		setNo(no); // 숫자 입력
		setKor(kor); // 한국어 점수 입력
		setEng(eng); // 영어 점수 입력
		setMath(math); // 수학 점수 입력
		total(kor, eng, math); // 총점 추출
		average(total, 3); // 평균 추출

	}

	/**
	 * 입력한 값을 1열로 뽑아내는 메서드 입니다. 5번 문제와 연관되있습니다.
	 * 
	 * @return
	 */
	public String info() {

		return getName() + "," + getBan() + "," + getNo() + "," + getKor() + "," + getEng() + "," + getMath() + ","
				+ getTotal() + "," + getAverage();

	}

	// getter and setter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBan() {
		return ban;
	}

	public void setBan(int ban) {
		this.ban = ban;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		total = kor + math + eng;
		return total;
	}

	/**
	 * 오버로딩 메서드 입니다.
	 * 
	 * @param kor
	 * @param eng
	 * @param math
	 * @return
	 */
	public int getTotal(int kor, int eng, int math) {
		total(kor, eng, math);
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAverage() {
		average(total, 3);
		return average;
	}

	/**
	 * 마찬가지로 오버로딩 메서드 입니다.
	 * 
	 * @param total
	 * @param subjectNumber
	 * @return
	 */
	public float getAverage(int total, int subjectNumber) {
		average = (float) total / subjectNumber;
		average = average * 10;
		average = (float) Math.round(average) / 10;
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	/**
	 * 총점을 구하는 메서드 입니다.
	 * 
	 * @param kor
	 * @param eng
	 * @param math
	 */
	public void total(int kor, int eng, int math) {
		total = kor + eng + math;
		setTotal(total);
	}

	/**
	 * 소수점 두번째 자리에서 반올림 하여 평균을 구하는 메서드 입니다.
	 * 
	 * @param total
	 * @param subjectNumber
	 */
	public void average(int total, int subjectNumber) {
		average = (float) total / subjectNumber;
		average = average * 10;
		average = (float) Math.round(average) / 10;
		setAverage(average);
	}
}
