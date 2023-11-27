package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
	        int value = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	        System.out.println("Giá trị tại nút A: " + value);
	        
	        for (Node child : node.getChildren()) {
	            int childValue = minValue(child, Integer.MIN_VALUE, Integer.MAX_VALUE);
	            System.out.println("Giá trị tại nút " + child.getLabel() + ": " + childValue);
	        }
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;
      //sắp xếp theo thứ tự bảng chữ cái
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Node.LabelComparator);

        for (Node child : sortedChildren) {//node.getChildren
            int value = minValue(child, alpha, beta);
            max = Math.max(max, value);
            alpha = Math.max(alpha, value);
            if (alpha >= beta) {
                System.out.println("Nút cắt: " + child.getLabel());
               break;
                
            }
        }

        return max;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		if (node.isTerminal()) {
            return node.getValue();
        }

        int min = Integer.MAX_VALUE;
      //sắp xếp theo thứ tự bảng chữ cái
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Node.LabelComparator);

        for (Node child : sortedChildren) {
            int value = maxValue(child, alpha, beta);
            min = Math.min(min, value);
            beta = Math.min(beta, value);
            if (beta <= alpha) {
                System.out.println("Nút cắt: " + child.getLabel());
                break;
               
            }
        }

        return min;
	}
}
