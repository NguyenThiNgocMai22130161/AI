package puzzle_8.student;

import java.util.Arrays;
import java.util.List;

public class TestNode {

	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("txt/PuzzleMap.txt", "txt/PuzzleGoalState.txt");

		IPuzzleAlgo greedy = new GreedyBestFirstSearch();
		IPuzzleAlgo a_star=new AStar();
		System.out.println(p.computeH1(p.getInitialState()));
		System.out.println(p.computeH2(p.getInitialState()));
		//System.out.println(p.moveWhiteTile(p.getInitialState(), 'r'));
		Node gredyy = greedy.execute(p);
		Node a_start = a_star.execute(p);
		for(Node n:PuzzleUtils.print(a_start)) {
			System.out.println(n.getG());
			System.out.println(n);
		
//		Node initialState = p.getInitialState();
//		Node tmp = new Node(initialState);
//		System.out.println(initialState.equals(tmp));
////		Node goalState = p.getGoalState();
//		System.out.println(p.getInitialState());
//		System.out.println("H: "+initialState.getH());
////		System.out.println(Arrays.toString(initialState.getWhiteTilePosition()));
//		System.out.println(p.getGoalState());
//		Node re = p.moveWhiteTile(initialState, 'r');
////
//		System.out.println(re);
//		System.out.println(re.getH());
//		System.out.println(initialState);
////		System.out.println(Arrays.toString(re.getWhiteTilePosition()));
////      System.out.println(p.computeH(init, goal));
//
//		// System.out.println(p.getInitialState());
//		// System.out.println(p.getGoalState());
//		//
////		 List<Node> children = p.getSuccessors(initialState);
////		 System.out.println("Size: "+children.size());
////		 for (Node child : children) {
////		 System.out.println(child.getH()+" "+p.computeH(child) );
		 }
	}
}
