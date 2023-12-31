package A.student;

public class HillClimbingWithRandomRestart implements ILocalSearchAlgo{
	int randomRestarts = 0;
	@Override
	public Node execute(Node initialState) {
		HillClimbingSearchNQueen hc = new HillClimbingSearchNQueen();
		Node state=hc.execute(initialState);

		while(state.getH()!=0) {
			state.generateBoard();
			randomRestarts ++;
			hc.stepClimbedAfterRandomRestart=0;
			state=hc.execute(state);
			
			
		}
		System.out.println("stepClimbed= "+ hc.stepClimbed);
		System.out.println("randomRestarts= "+randomRestarts);
		System.out.println("stepClimbedAfterRandomRestart"+hc.stepClimbedAfterRandomRestart);
		return state;
		
	}

}
