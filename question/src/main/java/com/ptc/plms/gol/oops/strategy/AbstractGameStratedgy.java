package com.ptc.plms.gol.oops.strategy;

import com.ptc.plms.gol.oops.rules.Rule;

/**
 * 
 * @author hdhingra
 *
 */
public abstract class AbstractGameStratedgy implements GameStrategy {

	private Rule [] rules; 
	
	@Override
	public void setRules(Rule[] rules) {
		this.rules = rules;
	}
	
	@Override
	public Rule[] getRules() {
		return rules;
	}

}
