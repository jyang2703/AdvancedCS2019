import java.io.File;
import java.util.Scanner;

public class WordRunner {

	public static void main(String[] args) {

		UniqueWord counter = new UniqueWord();

		try {
			Scanner s = new Scanner(new File("harry_potter.txt"));
			System.out.println("File is open");

			while (s.hasNext()) {
				String newWord = s.next();
				newWord = UniqueWord.stripCharacters(newWord).toLowerCase();
				counter.addWord(newWord);
			}
			s.close();

		} catch (Exception e) {
			System.out.println("Problem opening file");
		}
		
		
		counter.printWords();

	}

}
