package com.training.core.product;

import java.util.List;

public class ProductManager2 {

	private IOperation operation;

	public ProductManager2(final IOperation operation) {
		this.operation = operation;

	}

	public Product getProduct(final String name) {
		List<Product> allProducts = this.operation.getAllProducts();
		for (Product product : allProducts) {
			if (product.getName()
			           .equals(name)) {
				return product;
			}
		}
		return null;
	}

}
