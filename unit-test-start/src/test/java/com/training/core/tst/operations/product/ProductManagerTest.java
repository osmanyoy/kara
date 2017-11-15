package com.training.core.tst.operations.product;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.core.product.IOperation;
import com.training.core.product.Product;
import com.training.core.product.ProductManager2;

public class ProductManagerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetProduct() {
		IOperation operation = new OperationStub();
		ProductManager2 manager2 = new ProductManager2(operation);
		Product product = manager2.getProduct("Prod3");
		Assert.assertNotNull(product);
	}

}
