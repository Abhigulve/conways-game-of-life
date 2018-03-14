package rules;


import constants.State;

/**
 * 
 * @author hdhingra
 *
 */
public interface Rule {
	State nextState(State currentState, int liveNeighbours);
}
