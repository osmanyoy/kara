package com.training.core.product;

import java.util.List;
import java.util.Random;

public class ProductManager2 {

	private IOperation operation;

	public ProductManager2(final IOperation operation) {
		this.operation = operation;

	}

	public Product getProduct(final String name) {
		List<Product> allProducts = this.operation.getAllProducts();
		this.operation.getSize();
		Random random = new Random();
		int nextInt = random.nextInt(1000);
		this.operation.getRandom("rand" + nextInt);
		for (Product product : allProducts) {
			if (product.getName()
			           .equals(name)) {
				return product;
			}
		}
		return null;
	}

}
