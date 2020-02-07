import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TreeSearch {

	Node root;

	public void TreeQueue(Node root) { //queue traversal
		Queue<Node> q = new LinkedList<Node>();

		if (root == null) {
			return;
		}

		q.add(root);

		while (!q.isEmpty()) {

			// insert roots children into queue

			Node n = (Node) q.remove(); // remove current node from the queue

			System.out.println("Selected node: " + n.value);

			if (n.left != null) {
				q.add(n.left);
			}

			if (n.right != null) {
				q.add(n.right);
			}
		}

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();

	}
}

class Tree {
	
	Object[] array;
	int N;

	public Tree() {
		array = new Object [N];
	}
	
	public boolean empty() {
		return(array[1] == null);
	}
	
	public int left (int i) {
		return 2*i; 
	}
	
	public int right (int i) {
		return 2*i + 1;
	}
	
	public int parent (int i) {
		return i/2;
	}
	
	public Object getValue(int i) {
		if(i < 0 || i >= array.length) return null;
		return array[i];
	}
	
	public void setValue(int i, Object obj) {
		if(i < 0 || i>= array.length) {
			return;
		}
		array[i] = obj;
	}
}
