package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class UniformCostSearchAlgo implements ISearchAlgo {
	@Override
	public int compare(Node n1, Node n2) {
		int  re = Double.compare(n1.getPathCost(), n2.getPathCost());
		if( re ==0)
			return n1.getLabel().compareTo(n2.getLabel());
		else 
			return re;
	}
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node node = frontier.poll();
			if(node.getLabel() == goal)
				return node;
			explored.add(node);
			List<Edge> children = node.getChildren();
			for(Edge child : children) {
				double newPathCost = node.getPathCost() + child.getPathCost();
				Node n = child.getEnd();
				if (!frontier.contains(n) && !explored.contains(n)) {
					frontier.add(n); //setParent(),setPathCost()
					n.setParent(node);
				}else if (frontier.contains(n) && (n.getPathCost() > newPathCost)) {
					n.setPathCost(newPathCost);
					n.setParent(node);
				}
			}
		}
		return null;
	}

	@Override
	public Node execute (Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
			List<Node> explored = new ArrayList<>();
			frontier.add(root);
			while (!frontier.isEmpty()) {
				Node node = frontier.pop();
				if (node.getLabel() == goal)
					return node;
			else {
				List<Node> children = node.getChildrenNodes();
				for (int i = children.size() - 1; i >= 0; i--) {
					Node child = children.get(i);
					if (!frontier.contains(child) && !explored.contains(child)) {
						frontier.add(child);
						child.setParent(node);
						child.setDepth(node.getDepth() + 1);
					}
				}
			}
				
			}
		return null;
	}
}
