package chapter2.agent_AB; 

public class Environment {
	
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	private static final LocationState SUCK = null;
	
	

	public enum LocationState {
		CLEAN, DIRTY
	}

	

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		this.agent= agent;
		envState.setAgentLocation(location);
			
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		if(action == SUCK_DIRT) {
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		}else if(action == MOVE_RIGHT) {
			envState.setAgentLocation(LOCATION_A);
		}else if(action == MOVE_RIGHT) {
			envState.setAgentLocation(LOCATION_B);
		}
			
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		//gọi 2 thuôcj tính agentLocation và state => có ở trong lớp EnvironmentState
		Percept a = new Percept(envState.getAgentLocation(),envState.getLocationState(envState.getAgentLocation()));
		return a;
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
