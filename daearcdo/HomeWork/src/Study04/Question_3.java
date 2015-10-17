package Study04;

public class Question_3 {

	public static void main(String[] args) {
		Question_2 t = new Question_2();
		
		t.setChannel(10);
		System.out.println(t.getChannel());
		t.setChannel(20);
		System.out.println(t.getChannel());
		
		t.gotoprevchannel();
		System.out.println(t.getChannel());
		
	}
}
