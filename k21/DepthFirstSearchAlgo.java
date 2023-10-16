package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public  class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
		//List<Node> explored = new ArrayList<>();
	   while (!frontier.isEmpty()) {
		   Node node = frontier.pop();
		   if (node.equals(goal)) 
			   return node;
			   //explored.add(node);
			   
		   List<Node> children = node.getChildrenNodes();
		   for (Node child : children ) {
		   if(!frontier.contains(child));
			   frontier.push(child);
		        child.setParent(node);
		   }
	   }
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> frontier = new Stack<Node>();
		frontier.push(root);
		List<Node> explored = new ArrayList<>();
	   while (!frontier.isEmpty()) {
		   Node node = frontier.pop();
		   if (node.equals(goal)) 
			   return node;
			   explored.add(node);
			   
		   List<Node> children = node.getChildrenNodes();
		   for (Node child : children ) {
		   if(!frontier.contains(child));
			   frontier.push(child);
		        child.setParent(node);
		   }
	   }
		return null;
	}

	@Override
	public int compare(Node n1, Node n2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
