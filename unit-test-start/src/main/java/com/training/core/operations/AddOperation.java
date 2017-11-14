package com.training.core.operations;

public class AddOperation implements IOperation {

	@Override
	public int execute(final int firstVal, final int secondVal) {
		return firstVal + secondVal;
	}

	@Override
	public String menuText() {
		return "Add";
	}

}
