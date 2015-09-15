package jras.study.memory;

public class App {
	
	public void run() {
		Person p1 = new Person();
		p1.setName("이성대");
		p1.setAge(36);
		p1.setGender(1);
		p1.setNationality("korea");
		
		System.out.println(p1);
	}
	
	public static void main(String[] args) {
		new App().run();
	}
}
