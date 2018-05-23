package com.alz.jee.singleton.calc;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@LocalBean
@Singleton
public class MySingletonCalcEJB {

	public int add(int total,int addAmount) {
    	return total + addAmount;
    }

    public int subs(int total,int addAmount) {
    	return total - addAmount;
    }

}
