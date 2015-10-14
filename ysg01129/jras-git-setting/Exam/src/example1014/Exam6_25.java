package example1014;

import java.util.ArrayList;
import java.util.HashSet;

public class Exam6_25 {


	private final int MAX_CARD_NUMBER = 13;

	public static void main(String[] args) {
		Exam6_25 exam = new Exam6_25();
		exam.ildanmandlgoboza();
	}

	private void ildanmandlgoboza() {
		// TODO Auto-generated method stub

		ArrayList<String> cardNumber = new ArrayList<>();		
		ArrayList<String> cardPattern = new ArrayList<>();
		
		HashSet<String> hashSet = new HashSet<>();
		ArrayList<String> arrDeduplicationList;
		
		cardPattern.add("HEART");
		cardPattern.add("SPACE");
		cardPattern.add("DIAMOND");
		cardPattern.add("CLUB");
		
		for(int i=1;i<=MAX_CARD_NUMBER;i++) {
			if(i==1) {
				cardNumber.add("ACE");
			} else if(i==11) {
				cardNumber.add("JACK");
			} else if(i==12) {
				cardNumber.add("QUEEN");
			} else if(i==13) {
				cardNumber.add("KING");
			} else {
				cardNumber.add(i+"");
			}
		}
		
		while(hashSet.size()!=3) {
			int extnctionCardNumber = (int)(Math.random()*cardNumber.size());
			int extenctionCardPattenr = (int)(Math.random()*cardPattern.size());
			
			hashSet.add(cardPattern.get(extenctionCardPattenr) + " " + cardNumber.get(extnctionCardNumber));
		}
		
		arrDeduplicationList = new ArrayList<>(hashSet);
		
		String[] spiritText = null;
		for(int i=0;i<arrDeduplicationList.size();i++) {
			String text = arrDeduplicationList.get(i);
			spiritText = text.split(" ");
			System.out.println(spiritText[0] + " " + spiritText[1]);
		}
	}
}


// OOP 미완
class Card {


	private ArrayList<ArrayList<String>> card = new ArrayList<>();


	/**
	 * 카드 생성
	 */
	private void makeCard() {
		makeCardPattern();
	}

	/**
	 * 카드 모양 생성
	 */
	private void makeCardPattern() {
		for(int i=0;i<card.size();i++) {
			makeCardNumber(i);
		}
	}

	/**
	 * 카드 숫자 생성
	 * @param i
	 */
	private void makeCardNumber(int i) {
		for(int j=1;j<=13;j++) {			
			card.get(i).add(j+"");
		}
	}
}