package example1021;

public class Exam6_22 {

	public static Boolean isNumber(String str) {
		try {
			int judgeNum = Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까? " + isNumber(str));
	}

}
