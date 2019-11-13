import java.util.List;
import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	private List<Card> cards;
	private int size;


	public Deck(String[] ranks, String[] suits, int[] values) {
		this.cards = new ArrayList<Card>();
		for(int i=0; i<ranks.length; i++) {
			Card card = new Card(ranks[i], suits[i], values[i]);
			cards.add(card);
		}
		size = cards.size();
	}



	public boolean isEmpty() {
		return cards.isEmpty();
	}

	
	public int size() {
		return cards.size();
	}

	
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
	}

	public Card deal() {
		size--;
		if(size>0) {
			return cards.get(size);
		}
		return null;
	}

	
	public String toString() {
		String rtn = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			rtn = rtn + cards.get(k);
			if (k != size) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}