package A.student;

public class HillClimbingSearchNQueen implements ILocalSearchAlgo {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	//int randomRestarts = 0;
	public Node execute(Node initialState) {
		Node current = new Node(initialState);

		while (true) {
			Node neighbor = current.getBestCandidate();
			if (neighbor.getH() >= current.getH()) {
				return current;

			} else {
				current = neighbor;
				stepClimbed++;
				stepClimbedAfterRandomRestart++;

			}
		}
	}
}
