package strategy;


import rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public interface GameStrategy {

	//Set<Cell> findNeighbours(Cell cellFromCurrentGeneration, Set<Cell> liveCells);
	Rule[] getRules();
	void setRules(Rule[] rules);
}
