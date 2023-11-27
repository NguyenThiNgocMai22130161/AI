package game_alphabeta_student;

import java.util.*;

public class AlphaBetaRightToLeftSearchAlgo extends AlphaBetaSearchAlgo {
    @Override
    public int maxValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Collections.reverseOrder(Node.LabelComparator));

        for (Node child : sortedChildren) {
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

    @Override
    public int minValue(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int min = Integer.MAX_VALUE;
        List<Node> sortedChildren = new ArrayList<>(node.getChildren());
        sortedChildren.sort(Collections.reverseOrder(Node.LabelComparator));

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