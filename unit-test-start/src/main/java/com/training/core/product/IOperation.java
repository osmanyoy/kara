package com.training.core.product;

import java.util.List;

public interface IOperation {
	public List<Product> getAllProducts();

	public int getSize();

	public int getRandom(String str);
}
