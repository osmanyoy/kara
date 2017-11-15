package com.training.core.product;

import java.util.List;

public class ProductManager {

	private Operation operation = new Operation();

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
