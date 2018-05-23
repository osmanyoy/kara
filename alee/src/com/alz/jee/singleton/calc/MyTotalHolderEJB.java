package com.alz.jee.singleton.calc;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;

@LocalBean
@Stateful
public class MyTotalHolderEJB {
	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
