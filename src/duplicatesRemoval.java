import java.util.ArrayList;

public class duplicatesRemoval {

	
	
	
	
	
public static void removeDuplicates(ArrayList<String> list) {
		int dNum = 0;
		int lSize = list.size();
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (!list.get(j).equals(list.get(i))) continue;
				dNum++; //assumes there is a duplicate term
				list.remove(j);
				j--;
				lSize --;
			}
		}
		System.out.println("New List: " + list);
	}
	
	
	
	public static void main(String args[]) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Candice");
		names.add("Joe");
		names.add("Yuri");
		names.add("Candice");
		names.add("Yuri");
		
		removeDuplicates(names);
		
	}

}
