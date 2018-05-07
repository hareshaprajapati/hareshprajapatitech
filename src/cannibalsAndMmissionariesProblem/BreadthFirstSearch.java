package cannibalsAndMmissionariesProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// based on the breadth-first search algorithm present on the 3o Edition of the
// "Artificial Intelligence A Modern Approach".
public class BreadthFirstSearch {

	public State exec(State initialState) {
		if (initialState.isGoal()) {
			return initialState;
		}
		Queue<State> frontier = new LinkedList<State>();	// FIFO queue
		Set<State> explored = new HashSet<State>();
		frontier.add(initialState);
		int ifCondi=0;
		while (!frontier.isEmpty()) {
			State state = frontier.poll();
			explored.add(state);
			List<State> successors = state.generateSuccessors();
			for (State child : successors) {
				if (!explored.contains(child) /*|| !frontier.contains(child)*/) {
					System.out.println("if condition statisfied count : " + ++ifCondi);
					if (child.isGoal()) {
						return child;
					}
					frontier.add(child);
				}
			}
		}
		return null;	// failure
	}
}