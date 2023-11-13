package A.student;

public class SASearch implements ILocalSearchAlgo {

	@Override
	public Node execute(Node initialState) {
		Node current =new Node(initialState);
		Node next ;
		int denta;
		double T=1000.0;
		double coolingRate=0.995;
		while(current.getH()!=0) {
			if(T<=0) {
				return current;
			}
			next= current.selectNextRandomCandidate();
			denta=next.getH()-current.getH();//next phai be hon current moi lay
			if(denta<0) {
				current=next;
			}else if(Math.exp(denta/T)>Math.random()) {
					current=next;
				}
				T*=coolingRate;
			}
		System.out.println("T= "+T);

			return current;	}

}
