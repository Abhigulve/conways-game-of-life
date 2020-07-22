package rules;


import enums.State;

/**
 * @author abhijeet
 */
public class RuleImpl implements Rule {

    @Override
    public State nextState(State currentState, int liveNeighbours) {
        return currentState.getNextState(liveNeighbours);
    }

}
