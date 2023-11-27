package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		 int value = maxValue(node);
	        System.out.println("Giá trị tại nút A: " + value);
	        
	        for (Node child : node.getChildren()) {
	            int childValue = minValue(child);
	            System.out.println("Giá trị tại nút " + child.getLabel() + ": " + childValue);
	        }
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Node.LabelComparator);

        for (Node child : sortedChildren) {
            int value = minValue(child);
            max = Math.max(max, value);
        }
		return max;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		if (node.isTerminal()) {
            return node.getValue();
        }

        int min = Integer.MAX_VALUE;
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Node.LabelComparator);

        for (Node child : sortedChildren) {
            int value = maxValue(child);
            min = Math.min(min, value);
        }

        return min;
	}
}
