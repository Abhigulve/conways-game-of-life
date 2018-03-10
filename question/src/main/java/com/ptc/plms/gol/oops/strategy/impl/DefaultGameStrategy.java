package com.ptc.plms.gol.oops.strategy.impl;

import com.ptc.plms.gol.oops.rules.Rule;
import com.ptc.plms.gol.oops.strategy.AbstractGameStratedgy;

/**
 * @author hdhingra
 */
public class DefaultGameStrategy extends AbstractGameStratedgy {

    public DefaultGameStrategy(Rule[] rules) {
        setRules(rules);
    }

}
