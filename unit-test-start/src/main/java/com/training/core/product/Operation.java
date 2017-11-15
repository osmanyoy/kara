package com.training.core.product;

import java.util.Arrays;
import java.util.List;

public class Operation implements IOperation {

	@Override
	public List<Product> getAllProducts() {
		// DB operations
		return Arrays.asList(new Product("Prod1",
		                                 1),
		                     new Product("Prod1",
		                                 2),
		                     new Product("Prod1",
		                                 1));
	}

}
