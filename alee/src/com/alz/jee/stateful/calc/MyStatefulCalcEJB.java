package com.alz.jee.stateful.calc;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class MyStatefulCalcEJB
 */
@Stateful
@LocalBean
public class MyStatefulCalcEJB {

	private int total;

	public MyStatefulCalcEJB() {
    }
	
    public int add(int addAmount) {
    	total += addAmount;
    	return total;
    }

    public int subs(int addAmount) {
    	total -= addAmount;
    	return total;
    }


}
