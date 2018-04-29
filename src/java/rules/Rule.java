package rules;


import enums.State;

/**
 * 
 * @author abhijeet
 *
 */
public interface Rule {
	State nextState(State currentState, int liveNeighbours);
}
