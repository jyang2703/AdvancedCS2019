import java.util.Arrays;

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	
	public static void main(String[] args) {
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		String[] suit = {"Spades", "Clubs", "Hearts", "Diamonds"};
		int[] pointValue = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};

		
		Deck deck = new Deck(rank, suit, pointValue);
		System.out.println(deck.toString());
		deck.shuffle();
	}
}
