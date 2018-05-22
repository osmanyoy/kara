package com.alz.jee.customer.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class MyStatelessEJB
 */
@Stateless
@LocalBean
public class MyStatelessEJB {

    private int index;

    public MyStatelessEJB() {
    }
    
    public int getCurrentIndex() {
    	return ++index;
    }

}
