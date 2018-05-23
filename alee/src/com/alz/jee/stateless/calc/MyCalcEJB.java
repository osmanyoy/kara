package com.alz.jee.stateless.calc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyCalcEJB
 */
@Stateless
@LocalBean
public class MyCalcEJB {

    
	/**
     * Default constru ctor. 
     */
    public MyCalcEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public int add(int total,int addAmount) {
    	return total + addAmount;
    }

    public int subs(int total,int addAmount) {
    	return total - addAmount;
    }

}
