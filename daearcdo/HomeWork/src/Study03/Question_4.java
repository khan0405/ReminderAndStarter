package Study03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Question_4 {

	static int[] CARDNUMBER = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	static String[] CardPatten = { "Diamond", "Heart", "Spade", "Clubs" };

	public static void main(String[] args) {

		HashSet<String> CardNum = new HashSet<String>();
		HashSet<String> Cards = new HashSet<String>();
		ArrayList<String> CardNum1 = new ArrayList<>();
		ArrayList<String> Cards1 = new ArrayList<>();
		ArrayList<String> Card = new ArrayList<>();

		while (CardNum.size() < 3) {
			int CardVolume = (int) (Math.random() * 13) + 1;
			CardNum.add(String.valueOf(CardVolume));

		}
		while (Cards.size() < 3) {

			int CardCategory = (int) (Math.random() * 3) + 0;
			Cards.add(CardPatten[CardCategory].toString());

		}
		Iterator result = CardNum.iterator();
		while (result.hasNext()) {
			CardNum1.add(String.valueOf(result.next()));

		}
		Iterator result1 = Cards.iterator();
		while (result1.hasNext()) {
			Cards1.add(String.valueOf(result1.next()));

		}

		for (int i = 0; i < 3; i++) {
			Card.add(CardNum1.get(i).toString() + " / " + Cards1.get(i).toString());

		}

		for (int i = 0; i < Card.size(); i++) {
			System.out.println(Card.get(i).toString());
		}

	}

}
