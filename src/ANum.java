import java.util.ArrayList;
import java.util.LinkedHashSet;

public class ANum {
	


	public static void getPairs() {
		ArrayList<Integer> checked = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			int a = sumAllFactors(i);
			int b = sumAllFactors(a);
			if (i == b && i != a) {
				if (!checked.contains(i))
					checked.add(i);
				if (!checked.contains(a))
					checked.add(a);
			}
		}
		System.out.println("Pairs: " + checked);
	}

	public static int sumAllFactors(int a) {
		int sum = 0;
		for (int i = 1; i <= (int)(Math.sqrt(a)); i++) {
			if (a % i == 0) {
				sum += i;
				if(i != a/i) {
					sum += a/i;
				}
			}
		}
		return sum - a;
	}
	
	public static void main(String args[]) {
		getPairs();
	}

}
