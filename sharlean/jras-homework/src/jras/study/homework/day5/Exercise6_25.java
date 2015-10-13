package jras.study.homework.day5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import jras.study.homework.day5.PlayingCard.CardType;

/**
 * 1. 플레잉 카드 클래스를 정의
 * 
 * 1-1 플레잉 카드는 숫자를 가지며 숫자는 1~13까지 존재한다(1: A, 11: J, 12: Q, 13: K)
 * 
 * 1-2 플레잉 카드의 종류는 다이아몬드, 하트, 스페이드, 클럽의 4가지만 존재한다.
 * 
 * 2. 메인 메서드에서 임의의 카드 3장에 대해 각 카드의 숫자 및 종류를 출력하도록 하라.
 * 
 * 
 * @author Yunseong
 */
public class Exercise6_25 {
    public static void main(String[] args) {
        CardDeck deck = new CardDeck();

        System.out.println("현재 카드 수 : "     + deck.getCardCount() + "장");
        
        System.out.println("카드 세 장 뽑기 : "   + deck.getCard(3));
        
        System.out.println("카드 한 장 뽑기 : "   + deck.getCard());
        
        System.out.println("남은 카드 수 : "     + deck.getCardCount() + "장");
        
        System.out.println("카드 섞은 후 남은 카드 수  : " + deck.shuffle().getCardCount() + "장");
    }
}

/**
 * CardDeck 클래스.
 * 
 * 한 벌의 카드덱을 추상화한 클래스로, 임의의 순서를 가진 카드 한 벌을 가진다.
 * 
 * getCard() 메소드를 통해 임의의 카드를 꺼낼 수 있으며, 모두 소진되는 경우 카드 대신 null을 반환한다.
 * shuffle() 메소드를 통해서 또 다른 임의의 순서를 가진 카드 한 벌로 초기화가 가능하다.
 * 
 * @author Yunseong
 */
class CardDeck {
    private Queue<PlayingCard> cardDeckQueue = new LinkedList<PlayingCard>();
    
    public CardDeck() {
        cardDeckQueue = createCardDeck().shuffle();
    }
    
    /**
     * 카드 덱 한 벌을 만든다. 
     * 
     * 이 때 만드는 카드는 특정한 순서를 가지는 하나의 리스트 형태로 작성되며, 
     * 이후 shuffle() 메소드를 통해 실제 사용될 카드 한 벌이 만들어진다.
     * 
     * private으로 외부에서는 사용 불가능한 메소드 형태로 작성되고,
     * 오로지 생성자와 shuffle() 메소드에 의해서만 호출된다.
     * 
     * @return
     */
    private CardList<PlayingCard> createCardDeck() {
        CardList<PlayingCard> cardDeckList = new CardList<PlayingCard>();
        
        for(CardType cardType : CardType.values()) {
            for(int i = 1; i <= 13; i++) {
                try {
                    cardDeckList.add(new PlayingCard(i, cardType));
                } catch (Exception e) { 
                    e.printStackTrace();
                }
            }
        }
        
        return cardDeckList;
    }

    /**
     * 카드 한 장을 꺼낼 때 사용한다.
     * 카드가 한 장도 남아있지 않은 경우는 null을 리턴한다.
     * @return
     */
    public PlayingCard getCard() {
        return cardDeckQueue.size() > 0 ? cardDeckQueue.poll() : null;
    }
    
    /**
     * 카드 한 벌에서 카드를 여러장 꺼낼 때 사용된다.
     * 
     * 받은 인자수만큼 카드를 리스트 형태로 리턴하고, 만일 카드가 한 장도 남아있지 않은 경우는 null을 리턴한다.
     * 
     * @param cardCount
     * @return
     */
    public List<PlayingCard> getCard(int cardCount) {
        ArrayList<PlayingCard> cardList = new ArrayList<PlayingCard>();
        int i = 0;
        
        while(cardDeckQueue.size() > 0 && i < cardCount) {
            cardList.add(cardDeckQueue.poll());
            
            i++;
        }
        
        return cardList.size() > 0 ? cardList : null;
    }
    
    /**
     * 덱의 카드를 다시 섞은 다음, 바로 카드를 꺼낼 수 있도록 자기자신(CardDeck)을 리턴하도록 작성해보았다.
     * 다시 말해,
     * 
     * CardDeck deck = new CardDeck();
     * 
     * deck.shuffle().getCard(); 
     * 
     * 와 같은 형태로 연속된 형태의 메소드 호출이 가능하도록 작성해보았다.
     *  
     * @return
     */
    public CardDeck shuffle() {
        cardDeckQueue = createCardDeck().shuffle();
        
        return this;
    }
    
    public int getCardCount() {
        return cardDeckQueue.size();
    }

}

/**
 * CardList 클래스
 * 
 * 기존의  ArrayList를 상속받아 shuffle() 메소드를 추가한 클래스다.
 * 
 * CardDeck 클래스를 생성시, 임의의 순서로 정렬된 카드 한 벌을 만들기 위해 사용된다.
 * 임의의 순서를 가질 수 있는 방법은 많이 있지만, 
 * 
 * 상속을 사용하여 특화된 기능을 갖는 List 계열의 클래스를 만들어보자는 의미에서 작성해보았다. 
 * 
 * CardList 클래스는 shuffle() 메소드로 자신이 가진 카드 한 벌에 대해 임의의 순서값을 부여한 후, 
 * 이를 선입선출(FIFO) 형태로 꺼낼 수 있도록 Queue 형태로 이를 반환한다.
 *  
 * @author Yunseong
 * @param <T>
 */
class CardList<T> extends ArrayList<T> {
    private static final long serialVersionUID = 1L;

    public CardList() {
        super();
    }

    /**
     * shuffle 메소드는 CardList 클래스가 가진 카드 한 벌에 대해 임의의 순서값을 부여한 후,
     * Queue의 형태로 리턴하도록 하는 메소드다.
     *  
     * 일반적으로 LinkedList는 ArrayList에 비해 매우 느린 편이지만,
     * 카드을 한 번만 꺼낸다는 개념을 좀 더 직관적으로 표현해보고자 Queue 형태로 리턴하도록 해보았다.
     * 
     * @return
     */
    public Queue<T> shuffle() {
        HashSet<Integer> validateSet = new HashSet<Integer>();
        Queue<T> cardQueue = new LinkedList<T>();
        
        while(validateSet.size() < 46) {
            int no = (int)(Math.random() * 46) + 1; 
            
            if(!validateSet.contains(no)) {
                cardQueue.add(get(no));
                
                validateSet.add(no);
            }
        }
        
        return cardQueue;
    }
}

/**
 * PlayingCard 클래스
 * 
 * 흔히 '트럼프 카드'로 불리우는 카드를 추상화한 클래스.
 * 필드로 카드 번호와 카드 종류를 가진다.
 * 
 * 카드는 다이아몬드, 하트, 스페이드, 클럽의 4종류로 나뉘며
 * 또 한 종류의 카드는 총 13개로, 카드 번호 1 -> A, 11 -> J, 12 -> Q, 13 -> K를 의미한다.
 *
 * @author Yunseong
 */
class PlayingCard {
    // 카드 번호
    private int cardNo;
    
    // 카드 종류
    private CardType cardType;
    
    /**
     * 카드는 생성될 때만 카드 번호와 종류를 지정할 수 있으며, 한 번 지정된 값은 변경이 불가능하다.
     * 또한 카드 종류가 정의되지 않았거나, 카드 넘버가 적절하지 않은 경우 생성할 수 없다.
     * 
     * @param cardNo
     * @param cardType
     * @throws Exception
     */
    public PlayingCard(int cardNo, CardType cardType) throws Exception {
        if(cardType == null) throw new Exception("카드 타입이 null일 수 없습니다.");
        
        if(0 < cardNo && cardNo <= 13) {
            this.cardNo     = cardNo;
            this.cardType   = cardType;
        } else {
            throw new Exception("카드 넘버는 1부터 13까지만 가능합니다.");
        }
    }
    
    /**
     * 카드 타입은 다이아몬드, 하트, 스페이드, 클럽의 4종류만 존재한다.
     * 
     * @author Yunseong
     */
    public enum CardType {
        DIAMONDE("D"), HEART("H"), SPADE("S"), CLUB("C");
        
        String value;
        
        private CardType(String type) {
            this.value = type;
        }
        
        public String getValue() {
            return value;
        }
    }

    public int getCardNo() {
        return cardNo;
    }

    public CardType getCardType() {
        return cardType;
    }
    
    @Override
    public String toString() {
        return cardType + " " + cardNo;
    }
}