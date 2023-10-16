package k21;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
	//Queue<Node> frontier = new LinkedList<Node>();
	
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
	   while (!frontier.isEmpty()) {
		   Node node = frontier.poll();
		   if (node.equals(goal)) 
			   return node;
			   explored.add(node);
			   
		   List<Node> children = node.getChildrenNodes();
		   for (Node child : children ) {
		   if(!frontier.contains(child));
			   frontier.add(child);
		        child.setParent(node);
		   }
	   }
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		  frontier.add(root);
		List<Node> explored = new ArrayList<>();
	   while (!frontier.isEmpty()) {
		   Node node =  frontier.poll();
		   if (node.equals(goal)) 
			   return node;
			   explored.add(node);
		   
		   List<Node> children = node.getChildrenNodes();
		   for (Node child : children ) {
		   if(!frontier.contains(child));
			   frontier.add(child);
		         child.setParent(node);;
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
