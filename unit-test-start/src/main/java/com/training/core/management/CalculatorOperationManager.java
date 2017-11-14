package com.training.core.management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.training.core.operations.IOperation;

public class CalculatorOperationManager {
	private List<IOperation> operations = new ArrayList<>();

	public void addOperation(final IOperation operation) {
		this.operations.add(operation);
	}

	public Iterator<IOperation> getOperationsItrator() {
		return this.operations.iterator();
	}

	public String getMenu() {
		int index = 1;
		StringBuffer stringBuffer = new StringBuffer(100);
		for (IOperation iOperation : this.operations) {
			stringBuffer.append(index);
			stringBuffer.append("-");
			stringBuffer.append(iOperation.menuText());
			stringBuffer.append("\n");
			index++;
		}
		return stringBuffer.toString();
	}

	public int execute(final int index, final int firstVal, final int secondVal) {
		if ((index < 1) || (index > this.operations.size())) {
			throw new IllegalArgumentException("index should be between 1-" + this.operations.size());
		}
		IOperation iOperation = this.operations.get(index - 1);
		return iOperation.execute(firstVal,
		                          secondVal);
	}

}
