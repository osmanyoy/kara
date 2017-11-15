package com.training.core.product;

public class Product {
	private String name;
	private int index;

	public Product(final String name, final int index) {
		super();
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(final int index) {
		this.index = index;
	}

}
