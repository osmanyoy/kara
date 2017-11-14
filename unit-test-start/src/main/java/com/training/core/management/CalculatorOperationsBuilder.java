package com.training.core.management;

import com.training.core.operations.AddOperation;
import com.training.core.operations.MultiplyOperation;

public class CalculatorOperationsBuilder {
	public static CalculatorOperationManager getCalcManager() {
		CalculatorOperationManager com = new CalculatorOperationManager();
		AddOperation addOperation = new AddOperation();
		com.addOperation(addOperation);
		MultiplyOperation multOperation = new MultiplyOperation();
		com.addOperation(multOperation);
		return com;
	}
}
