package lab4.inform.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import javax.swing.text.AsyncBoxView.ChildLocator;





public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo{
	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				Double h1 =o1.getH();
				Double h2 = o2.getH();
				int result=h1.compareTo(h2);
				if(result==0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}
				return result;
			}
		});

		List<Node> explored = new ArrayList<>();
			frontier.add(root);
			
			while (!frontier.isEmpty()) {
				Node current = frontier.poll();
				explored.add(current);
				if (current.getLabel().equals(goal)) 
		    return current;
				else {
					explored.add(current);
					List<Edge> child = current.getChildren();
			for (Edge childEdge : current.getChildren()) {
				Node childNode = childEdge.getEnd();//
				if (!explored.contains(childNode) && !frontier.contains(childNode)){
					childNode.setParent(current);childNode.setG(current.getG() + childEdge.getWeight());
					frontier.add(childNode);
				}
			}
			}}
					return null;
				
			}
	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				Double h1 =o1.getH();
				Double h2 = o2.getH();
				int result=h1.compareTo(h2);
				if(result==0) {
					return o1.getLabel().compareTo(o2.getLabel());
				}
				return result;
			}
		});
		List<Node> explore = new ArrayList<Node>();
		frontier.add(root);
		
		while (!frontier.isEmpty()) {
			Node check = frontier.poll();
			if (!check.getLabel().equals(start)) {
				for (Node c : check.getChildrenNodes()) {
					frontier.add(c);
				}
			} else {
				frontier.clear();
				frontier.add(check);

				while (!frontier.isEmpty()) {
					
					Node current = frontier.poll();
					System.out.println("Current: " + current.getLabel());
					if (current.getLabel().equals(goal)) {
						return current;
					} else {
						explore.add(current);
						for (Node n : current.getChildrenNodes()) {
							if ((!frontier.contains(n)&&(!explore.contains(n)))) {
								n.setParent(current);
								for (Edge i : n.getParent().getChildren()) {
									if (i.getEnd().getLabel().equals(n.getLabel())) {
										n.setG(i.getWeight() + n.getParent().getG());
									}
								}

								frontier.add(n);
								System.out.println("add: " + n.getLabel());

							} else {
								Node parentBefore = n.getParent();
								double before = n.getG();
								n.setParent(current);
								for (Edge i : n.getParent().getChildren()) {
									if (i.getEnd().getLabel().equals(n.getLabel())) {
										n.setG(i.getWeight() + n.getParent().getG());
									}
								}

								double after = n.getG();
								if (after >= before) {
									n.setParent(parentBefore);
									n.setG(before);
								}

							}

						}

					}
					System.out.println(frontier.toString());
					System.out.println("------------\n");
				}
			}}
		

		System.out.println("khong tim thay duong di trong");
		return null;
	}

}