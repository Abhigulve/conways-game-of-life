package strategy.impl;


import rules.Rule;
import strategy.AbstractGameStratedgy;

/**
 * @author hdhingra
 */
public class DefaultGameStrategy extends AbstractGameStratedgy {

    public DefaultGameStrategy(Rule[] rules) {
        setRules(rules);
    }

}
