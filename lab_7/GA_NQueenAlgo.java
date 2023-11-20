package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
		public static final int POP_SIZE = 100;//Population size
		public static final double MUTATION_RATE = 0.03;
		public static final int MAX_ITERATIONS = 1000;
		List<Node> population = new ArrayList<Node>();
		Random rd = new Random();
		// initialize the individuals of the population
		public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
		Node ni = new Node();
		ni.generateBoard();
		population.add(ni);
		}
		}
		public Node execute() {
			    int k = 0;
			    initPopulation();
			    while (k++ < MAX_ITERATIONS) {
			    	List<Node> newPopulation = new ArrayList<>();
			    	for ( int i = 0; i < POP_SIZE; i++) {
			        // Selection
			        Node x = getParentByTournamentSelection();
			        Node y = getParentByTournamentSelection();

			        // Reproduction
			        Node child = reproduce(x,y);

			        if (rd.nextDouble() < MUTATION_RATE) {
			        // Mutation
			        mutate(child);
			    	}
			        // Check for solution
			        if (child.getH() == 0) {
			            return child;
			        }else {
			        newPopulation.add(child);
			    	}
			    }//end for
			    	population = newPopulation;
			    }
                    Collections.sort(population);
//			        // Update best solution if necessary
//			        if (child.getH() < bestFitness) {
//			            bestFitness = child.getH();
//			            bestSolution = child;
//			        }
//
//			       k++;
//			    }
			    // Return the best solution found
			    return population.get(0);
}
		
		// Mutate an individual by selecting a random Queen and 
		//move it to a random row.
		public void mutate(Node node) {
		int queenIndex = rd.nextInt(Node.N);
		int newRow = rd.nextInt(Node.N);
		if (newRow != node.getRow(queenIndex)) {
		node.setRow(queenIndex,newRow);
		}else {
			mutate(node);
		}
		}
		//Crossover x and y to reproduce a child
		public Node reproduce(Node x, Node y) {
		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for  (int i = c + 1; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
		}
		// Select K individuals from the population at random and 
		//select the best out of these to become a parent.
		public Node getParentByTournamentSelection() {
//		int tournameSize = 5;
		List<Node> tourname = new ArrayList<>();
//		for (int i = 0; i < tournameSize; i++) {
//			tourname.add(population.get(rd.nextInt(population.size())));
//		}
//		Node bestParent = tourname.get(0);
//		int bestFitness = bestParent.getH();
//		for (int i = 1; i < tournameSize; i++) {
//			Node curent = tourname.get(i);
//			int ct = curent.getH();
//			
//		}
//		return bestParent;
//		}
			//Node bestParent = null;
			for (int i = 0; i < 4; i++) {
				int randomIndex = rd.nextInt(POP_SIZE);
				Node candidate = population.get(randomIndex);
//				if (bestParent == null || candidate.getH() > bestParent.getH()) {
//					bestParent = candidate;
//				}
				tourname.add(candidate);
			}
			Collections.sort(tourname);
			return tourname.get(0);
			}
		//Select a random parent from the population
		public Node getParentByRandomSelection() {
		int randomIndex = rd.nextInt(POP_SIZE);
		return population.get(randomIndex);
		}
}
