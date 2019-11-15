import java.util.List;
import java.util.ArrayList;


public class Deck {

	private List<Card> cards;
	private int size;

	public Deck(String[] ranks, String[] suits, int[] values) {
		this.cards = new ArrayList<Card>();
		for (String s : suits) {
				for (int i = 0; i < ranks.length; i++) {
					
					cards.add(new Card(ranks[i], s, values[i]));
				}
			
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
		 for (int k = cards.size() - 1; k > 0; k--) 
			{
				int newDecksize = k + 1;
				int start = 0;
				int randPos = (int) (Math.random() * newDecksize) + start;
				Card temp = cards.get(k);
				cards.set(k, cards.get(randPos));
				cards.set(randPos, temp);
			}
			size = cards.size();
		 }

	public Card deal() {
		size--;
		if (size > 0) {
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