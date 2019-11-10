import java.util.ArrayList;

public class UniqueWord {

	ArrayList<Integer> wordCount;
	ArrayList<String> words;

	public UniqueWord() {
		words = new ArrayList<String>();
		wordCount = new ArrayList<Integer>();
	}

	public static String stripCharacters(String ws) {
		int i, j;

		for (i = ws.length() - 1; i > 0; i--) {
			if (Character.isLetter(ws.charAt(i))) {
				break;
			}
		}
		ws = ws.substring(0, i + 1);
		// trim beginning non-Letter
		for (j = 0; j < i; j++) {
			if (Character.isLetter(ws.charAt(j))) {
				break;
			}
		}
		ws = ws.substring(j, i + 1);
		return ws;
	}

	public void addWord(String word) {
		int index = words.indexOf(word);
		// 2 arrays: a string and int
		if (index >= 0) {
			// Current word exists in the ArrayList
			Integer curCount = wordCount.get(index);
			curCount++;
			wordCount.set(index, Integer.valueOf(curCount));

		} else {
			// Current word does not exist
			words.add(word);
			wordCount.add(1);

		}
	}

	public void printWords() {
		for (int i = 0; i < words.size(); i++) {
			System.out.println(words.get(i) + ": " + wordCount.get(i));
		}
	}

}
