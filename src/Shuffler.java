/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	private static final int SHUFFLE_COUNT = 1;
/*
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive perfect shuffles:");
		int[] values1 = { 0, 1, 2, 3 };
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT + " consecutive efficient selection shuffles:");
		int[] values2 = { 0, 1, 2, 3 };
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}*/

	/*
	 * public static void perfectShuffle(int[] values) { int[] shuffled = new
	 * int[values.length];
	 * 
	 * int count = 0; int j = 0; for (j = 0; j < 25; j++) { shuffled[count] =
	 * values[j]; count += 2; }
	 * 
	 * count = 1; for (; j < 51; j++) { shuffled[count] = values[j]; count += 2; }
	 * 
	 * for (count = 0; count < values.length; count++) { values[count] =
	 * shuffled[count]; }
	 * 
	 * }
	 * 
	 * public static void selectionShuffle(int[] values) {
	 * 
	 * for (int count = values.length - 1; count > 0; count--) { int position =
	 * (int) (Math.random() * (count + 1)); int temp = values[position];
	 * values[position] = values[count]; values[count] = temp; } }
	 */

	public static void perfectShuffle(int[] values) {
		int[] temp = new int[values.length];
		int mid = (values.length + 1) / 2;

		// Interleave elements 0 ... mid-1 with elements mid ... length-1
		int unshuffledPos = 0;
		int k = 0;
		for (; k < mid; k++) {
			temp[unshuffledPos] = values[k];
			unshuffledPos += 2;
		}
		unshuffledPos = 1;
		for (; k < values.length; k++) {
			temp[unshuffledPos] = values[k];
			unshuffledPos += 2;
		}

		// Copy elements back to values
		for (k = 0; k < values.length; k++) {
			values[k] = temp[k];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument. The selection shuffle
	 * algorithm conceptually maintains two sequences of cards: the selected cards
	 * (initially empty) and the not-yet-selected cards (initially the entire deck).
	 * It repeatedly does the following until all cards have been selected: randomly
	 * remove a card from those not yet selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid searching
	 * for an as-yet-unselected card.
	 * 
	 * @param values
	 *            is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for (int k = values.length - 1; k > 0; k--) {
			int pos = (int) (Math.random() * (k + 1)); // range 0 to k, inclusive
			int temp = values[pos];
			values[pos] = values[k];
			values[k] = temp;
		}
	}

	public static boolean arePermutations(int[] a, int[] b) {

		boolean found = false;

		for (int aValue : a) {
			found = false;
			for (int bValue : b) {
				if (bValue == aValue) {
					found = true;
				}
			}
			if (found == false) {
				return false;
			}
		}
		return true;
	}
}
