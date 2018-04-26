package rules;


import constants.State;

/**
 * 
 * @author abhijeet
 *
 */
public interface Rule {
	State nextState(State currentState, int liveNeighbours);
}
