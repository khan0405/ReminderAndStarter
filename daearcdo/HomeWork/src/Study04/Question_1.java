package Study04;

import java.util.regex.Pattern;

public class Question_1 {

	public static void main(String[] args) {

		String str = "123";
		System.out.println(str + " 는 숫자입니까? " +isNumber(str));
		
		String str1 = "가나";
		System.out.println(str + " 는 숫자입니까? " +isNumber(str1));
		
		String str2 = "123 ";
		System.out.println(str + " 는 숫자입니까? " +isNumber(str2));
		
		String str3 = "12ㅇ";
		System.out.println(str + " 는 숫자입니까? " +isNumber(str3));
		

	}

	public static boolean isNumber(String str) {

		return Pattern.matches("[0-9]+", str);
	}
}
