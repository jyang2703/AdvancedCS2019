/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 */
public class Card {

	private String suit;
	private String rank;
	private int pointValue;

	
	public Card(String cardRank, String cardSuit, int cardPointValue) {
		rank = cardRank;
		suit = cardSuit;
		pointValue = cardPointValue;
	}

	public String suit() {
		return suit;
	}

	public String rank() {
		return rank;
	}

	public int pointValue() {
		return pointValue;
	}


	public boolean matches(Card otherCard) {
		if (suit.equals(otherCard.suit) && rank.equals(otherCard.rank) && pointValue == otherCard.pointValue) {
	           return true;
	        }
	        return false;
	}

	
	public String toString() {
		return suit + " of " + rank + " (point value = " + pointValue + ") ";
	}
}