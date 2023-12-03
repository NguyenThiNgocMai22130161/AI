package Lap9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		data.sort(DESCOMPARATOR);
		List <Node> s = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			for(int j = 1; j <= data.get(i) / 2; j++) {
				//if(!data.contains(data.get(i) - j)) {//
				if(j != data.get(i) - j) {
					Node successor = new Node();
					List<Integer> n = new ArrayList<>(data);//
					n.set(i, data.get(i) - j);//
					n.add(j);
					successor.addAll(n);//
					s.add(successor);//
//					for (int k = 0; k < data.size(); k++) {
//						if( k != i) {
//							successor.add(data.get(k));
//						}
//					}
				}
			}
		}
		return s;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		data.sort(DESCOMPARATOR);
		return data.get(0) <= 2;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};
	private static final boolean isPlayerTurn = false;

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

	public int getUtility(Node node) {
		// Calculate and return the utility value for the terminal state
        if (isPlayerTurn) {
            // If it's the maximizing player's turn in a terminal state, the minimizing player wins
            return -1;
        } else {
            // If it's the minimizing player's turn in a terminal state, the maximizing player wins
            return 1;
        }
	}
}
