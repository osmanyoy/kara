package com.training.core.tst.operations.product;

import java.util.Arrays;
import java.util.List;

import com.training.core.product.IOperation;
import com.training.core.product.Product;

public class OperationStub implements IOperation {

	@Override
	public List<Product> getAllProducts() {
		return Arrays.asList(new Product("Prod2",
		                                 1),
		                     new Product("Prod3",
		                                 2),
		                     new Product("Prod4",
		                                 3));
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public int getRandom(final String str) {
		// TODO Auto-generated method stub
		return 0;
	}

}
