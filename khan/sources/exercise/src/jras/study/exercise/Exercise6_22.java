package jras.study.exercise;

import java.util.regex.Pattern;

/**
 * [6-22] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.
 *
 *   메서드명 : isNumber
 *   기 능 : 주어진 문자열이 모두 숫자로만 이루어져있는지 확인한다.
 *   모두 숫자로만 이루어져 있으면 true를 반환하고,
 *   그렇지 않으면 false를 반환한다.
 *   만일 주어진 문자열이 null이거나 빈문자열 "" 이라면 false를 반환한다.
 *   반환타입 : boolean
 *   매개변수 : String str - 검사할 문자열
 *
 * Created by KHAN on 2015-10-17.
 */
public class Exercise6_22 {
	/*
		(1) isNumber메서드를 작성하시오.
	*/

	/**
	 * 정규식을 이용한 숫자 체크 메서드
	 * @param str 체크할 문자열
	 * @return 숫자로 이루어진 문자인지의 여부
	 */
	static boolean isNumber(String str) {
		return Pattern.matches("^[+-]?\\d*(\\.?\\d*E?\\d*)$", str);
	}

	/**
	 * Number format exception을 이용한 숫자 체크 메서드
	 * @param str 체크할 문자열
	 * @return 숫자로 이루어진 문자인지의 여부
	 */
	static boolean isNumber2(String str) {
		try {
			double doubleValue = Double.parseDouble(str);
			return true;
		}
		catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 문자 배열을 이용한 숫자 체크 메서드
	 * @param str 체크할 문자열
	 * @return 숫자로 이루어진 문자인지의 여부
	 */
	static boolean isNumber3(String str) {
		if (str == null || str.trim().isEmpty()) {
			return false;
		}
		int dotCount = 0;
		int index = 0;
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			if (c == '.') {
				dotCount++;
				if (dotCount > 1)
					return false;
				if (index == charArr.length - 1)
					return false;
			}
			else if (c < '0' || c > '9') {
				return false;
			}
			index++;
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? " + isNumber(str));
		str = "1234o";
		System.out.println(str+"는 숫자입니까? " + isNumber(str));
		str = "123.4";
		System.out.println(str+"는 숫자입니까? " + isNumber(str));
		str = "1.E4";
		System.out.println(str+"는 숫자입니까? " + isNumber(str));
		str = String.valueOf(Double.MAX_VALUE);
		System.out.println(str+"는 숫자입니까? " + isNumber(str));
	}
}
