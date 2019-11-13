/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 * 
	 * @param args
	 *            is not used.
	 */
	public static void main(String[] args) {
		String[] rank1 = { "Jack", "Queen", "King" };
		String[] suit1 = { "Hearts", "Spades", "Diamonds" };
		int[] value1 = { 11, 12, 13 };

		Deck deck1 = new Deck(rank1, suit1, value1);
		System.out.println("Deck 1 size: " + deck1.size());

		String[] rank2 = { "5", "2", "Queen" };
		String[] suit2 = { "Clubs", "Spades", "Diamonds" };
		int[] value2 = { 5, 2, 12 };

		Deck deck2 = new Deck(rank2, suit2, value2);
		System.out.println("Deck 2 size: " + deck2.size());

		String[] rank3 = { "4", "Jack", "9" };
		String[] suit3 = { "Spades", "Spades", "Hearts" };
		int[] value3 = { 4, 11, 9 };

		Deck deck3 = new Deck(rank3, suit3, value3);
		System.out.println("Deck 3 size: " + deck3.size());

	}
}
