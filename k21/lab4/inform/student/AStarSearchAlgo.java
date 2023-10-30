package lab4.inform.student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarSearchAlgo implements IInformedSearchAlgo{

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
			Node node = frontier.poll(); // Chooses the lowest-cost node in frontier
			//explored.add(root);
			
			if (node.getLabel().equals(goal)) {
				return node;
			}else {
				explored.add(node);
				List<Edge> children = node.getChildren();
				for (Edge child : children) {
					Node n = child.getEnd();
					if (!frontier.contains(n) && !explored.contains(n)) {
						n.setParent(node);
						n.setG(n.getG() + child.getWeight());
						frontier.add(n);

					} else {
						Node parentBefore = n.getParent();
					double before = n.getG();
					n.setParent(node);
					for (Edge i : n.getParent().getChildren()) {
						if (i.getEnd().getLabel().equals(n.getLabel())) {
							n.setG(i.getWeight() + n.getParent().getG());
					}
				}
				double after = n.getG();
				if (after > before) {
					n.setParent(parentBefore);
					n.setG(before);
				}
					}}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
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
					// System.out.println("of-"+current.getParent().getLabel());
					System.out.println("GOAL");
					System.out.println("Goal :" + current.getLabel() + "-" + current.getG());
					return current;
				} else {
					explore.add(current);
					for (Node n : current.getChildrenNodes()) {
						if ((!frontier.contains(n)) && (!explore.contains(n))) {
							n.setParent(current);
							for (Edge i : n.getParent().getChildren()) {
								if (i.getEnd().getLabel().equals(n.getLabel())) {
									n.setG(i.getWeight() + n.getParent().getG());
								}
							}

							frontier.add(n);
							System.out.println("add: " + n.getLabel() + "-" + n.getG());

						} else {

							Node parentBefore = n.getParent();
							double before_G = n.getG();
							n.setParent(current);
							for (Edge i : n.getParent().getChildren()) {
								if (i.getEnd().getLabel().equals(n.getLabel())) {
									n.setG(i.getWeight() + n.getParent().getG());

								}

							}
							double after_G = n.getG();
							System.out.println("lap lai :" + n.getLabel());
							System.out.println("before_G of " + n.getLabel() + ": " + before_G);
							System.out.println("after_G of " + n.getLabel() + ": " + after_G);
							if (after_G >= before_G) {
								n.setParent(parentBefore);
								n.setG(before_G);
							}

						}

					}

				}
				
				System.out.print("[");
				for (Node e : frontier) {

					System.out.print(e + "_" + e.getG() + "/" + (e.getG() + e.getH()) + ", ");
				}
				System.out.print("]");
				System.out.println();
				System.out.println("------------\n");
			}
				}
			}
			System.out.println("khong tim thay duong di trong");
			return null;
		}
	}