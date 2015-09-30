package presentation;

import java.awt.image.AreaAveragingScaleFilter;

public class Method_Scope {

	String areaScope = "1";
	static String staticScope = "2";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		startMethod();
		parameterMethod(1);
		returnMethod();
		overloadingMethod(1);
		overloadingMethod("문자열");
		firstMethod();
		fx(1);
		
		Method_Scope method = new Method_Scope();
		
		String localScope = "3";
		
		String instanceScope = new String();
				
		System.out.println("지역 변수 : " + localScope);
		System.out.println("전역 변수 : " + method.areaScope);
		System.out.println("스태틱 변수 : " + staticScope);
		System.out.println("인스턴스 변수 : " + instanceScope);
		
	}
	
	private static void startMethod() {
		System.out.println("메소드를 시작합니다.");
	}
	
	private static void parameterMethod(int i) {
		System.out.println("매개변수를 받은 메소드 입니다. "
				+ "매개변수는 " + i + "입니다.");
	}
	
	private static int returnMethod() {
		int i = 100;
		System.out.println("값을 반환하는 메소드 입니다. "
				+ "반환 값은 " + i + "입니다.");
		return i;
	}
	
	private static void overloadingMethod(int i) {
		System.out.println("오버로딩 하는 메소드 입니다. 매개변수는 " + i + "입니다.");
	}
	
	private static void overloadingMethod(String i) {
		System.out.println("오버로딩 하는 메소드 입니다. 매개변수는 " + i + "입니다.");
	}
	
	private static void firstMethod() {
		System.out.println("첫번째 메소드 입니다. "
				+ "두번째 메소드로 이동합니다.");
		secondMethod();
	}
	
	private static void secondMethod() {
		System.out.println("두번째 메소드 입니다. 세번째 메소드로 이동합니다.");
		thirdMethod("Hello");
	}
	
	private static void thirdMethod(String text) {
		System.out.println("세번쨰 메소드 입니다. 매개변수는 " + text + "입니다.");
	}
	
	private static void fx(int i) {
		int sum = i + 1;
		System.out.println("합은 = " + sum + "입니다.");
	}

	
}
