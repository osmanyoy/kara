package com.training.core.operations;

public class MultiplyOperation implements IOperation {

	public int execute(final int firstVal, final int secondVal) {
		return firstVal * secondVal;
	}

	public String menuText() {
		return "Multiply";
	}

}
