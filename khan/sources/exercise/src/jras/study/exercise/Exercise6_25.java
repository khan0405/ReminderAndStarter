package jras.study.exercise;

import java.util.*;
import java.util.function.Consumer;

/**
 * 1. 플레잉 카드 클래스를 정의
 *   1-1. 플레잉 카드는 숫자를 가지며 숫자는 1~13까지 존재한다.(1 : A, 11 : J, 12 : Q, 13 : K)
 *   1-2. 플레잉 카드의 종류는 다이아몬드, 하트, 스페이드, 클럽의 4가지만 존재한다.
 * 2. 메인 메서드에서 임의의 카드 3장에 대해 각 카드의 숫자 및 종류를 출력하도록 하라.
 * (단, 이미 출력한 카드는 다시 나올 수 없도록 해야 한다. 중복 불가.)
 * Created by KHAN on 2015-10-09.
 */
public class Exercise6_25 {
	public static void main(String[] args) {
		CardDeck deck = new CardDeck();
		deck.suffle();
		List<Card> cards1 = deck.dealCards(3);
		List<Card> cards2 = deck.dealCards(3);
		List<Card> cards3 = deck.dealCards(3);
		System.out.printf("cards1: %s \n", cards1);
		System.out.printf("cards2: %s \n", cards2);
		System.out.printf("cards3: %s \n", cards3);
	}
}

/**
 * 카드 덱 클래스
 * 카드를 섞거나 정렬하거나 분배 및 반환을 할 수 있다.
 */
class CardDeck implements Iterable<Card> {
	private static final int MIN_CARD_VALUE = 1;
	private static final int MAX_CARD_VALUE = 13;

	private List<Card> cards;

	public CardDeck() {
		initializeDeck();
	}

	/**
	 * 카드 정보 생성
	 */
	private void initializeDeck() {
		cards = new ArrayList<>();
		for (int cardNumber = 0; cardNumber < MAX_CARD_VALUE; cardNumber++) {
			for (CardSuit suit : CardSuit.values()) {
				cards.add(new Card(cardNumber + 1, suit));
			}
		}
	}

	/**
	 * 카드를 무작위로 섞는다.
	 */
	public void suffle() {
		Collections.shuffle(cards);
	}

	/**
	 * 카드를 정렬한다.
	 */
	public void sort() {
		Collections.sort(cards);
	}

	/**
	 * 카드를 역순으로 정렬한다.
	 */
	public void reverse() {
		Collections.reverse(cards);
	}

	/**
	 * 카드를 거래한다.
	 * 거래할 카드의 갯수보다 덱에 있는 카드가 적으면, 덱에 있는 카드만큼만 거래된다.
	 *
	 * @param cardCount 거래할 카드의 갯수
	 * @return 거래할 카드.
	 */
	public List<Card> dealCards(int cardCount) {
		List<Card> resultCards = new ArrayList<>();
		while(cardCount-- > 0 && cards.size() > 0) {
			Card card = cards.remove(0);
			resultCards.add(card);
		}
		return resultCards;
	}

	/**
	 * 카드를 덱에 반환한다.
	 *
	 * @param card 덱에 반환할 카드
	 * @return 반환되었는지의 여부. 이미 덱에 있는 경우라면 반환되지 않는다.
	 */
	public boolean returnCardToCardDeck(Card card) {
		if (cards.contains(card)) {
			return false;
		}
		return cards.add(card);
	}
	/**
	 * 카드들을 덱에 반환한다.
	 *
	 * @param retCards 덱에 반환할 카드들
	 * @return 반환되었는지의 여부. 이미 덱에 있는 경우라면 반환되지 않는다.
	 */
	public boolean returnCardsToCardDeck(List<Card> retCards) {
		if (cards.containsAll(retCards)) {
			return false;
		}
		return cards.addAll(retCards);
	}

	/**
	 * 카드 정보를 리셋한다.
	 */
	public void resetCards() {
		initializeDeck();
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}

	@Override
	public void forEach(Consumer<? super Card> action) {
		cards.forEach(action);
	}

	@Override
	public Spliterator<Card> spliterator() {
		return cards.spliterator();
	}
}

/**
 * 카드 클래스.
 *
 * 카드는 숫자 정보와 모양 정보를 가지며, 특정 숫자(1, 11, 12, 13)은 각각의 이름을 가진다.
 */
class Card implements Comparable<Card> {
	// 특정 숫자의 이름
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;

	/** 카드 숫자 */
	private int number;
	/** 카드 모양 */
	private CardSuit suit;

	public Card(int number, CardSuit suit) {
		this.number = number;
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public CardSuit getSuit() {
		return suit;
	}

	@Override
	public int compareTo(Card o) {
		int compare = this.number - o.number;
		if (compare == 0) {
			if (suit == null || o.getSuit() == null) {
				return 0;
			}
			return suit.getOrder() - o.getSuit().getOrder();
		}
		return compare;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Card)) return false;
		Card card = (Card) o;
		return Objects.equals(getNumber(), card.getNumber()) && Objects.equals(getSuit(), card.getSuit());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getNumber(), getSuit());
	}

	@Override
	public String toString() {
		return "Card{" + suit + " " + number + "}";
	}
}

/**
 * 카드의 모양 정보
 *
 * 각 모양마다 순위를 가진다.
 */
enum CardSuit {

	DIAMONDS(1),
	CLUBS(2),
	HEARTS(3),
	SPADES(4);

	/** 카드의 순위 */
	private int order;

	CardSuit(int order) {
		this.order = order;
	}

	public static CardSuit valueOf(int order) {
		switch (order) {
			case 1: return DIAMONDS;
			case 2: return CLUBS;
			case 3: return HEARTS;
			case 4: return SPADES;
			default: throw new IllegalArgumentException("Order value is from 1 to 4.");
		}
	}

	public int getOrder() {
		return order;
	}
}