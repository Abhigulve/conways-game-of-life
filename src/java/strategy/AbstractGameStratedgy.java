package strategy;


import rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public abstract class AbstractGameStratedgy implements GameStrategy {

	private Rule[] rules;
	
	@Override
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	@Override
	public Rule[] getRules() {
		return rules;
	}

}
