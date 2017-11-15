package com.training.core.tst.operations.product;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.training.core.product.IOperation;
import com.training.core.product.Product;
import com.training.core.product.ProductManager2;

public class ProductManagerTestWithMock {

	@Mock
	private IOperation operation;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		// IOperation operation = Mockito.mock(IOperation.class);
		Product productTest = new Product("Prod3",
		                                  2);
		List<Product> asList = Arrays.asList(new Product("Prod2",
		                                                 1),
		                                     new Product("Prod3",
		                                                 2),
		                                     new Product("Prod4",
		                                                 3));

		Mockito.when(this.operation.getAllProducts())
		       .thenReturn(asList);

		ProductManager2 manager2 = new ProductManager2(this.operation);

		Product product = manager2.getProduct("Prod3");

		ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

		Mockito.verify(this.operation,
		               Mockito.times(1))
		       .getAllProducts();

		Mockito.verify(this.operation,
		               Mockito.times(1))
		       .getRandom(arg.capture());

		System.out.println(arg.getValue());

		Mockito.verify(this.operation)
		       .getSize();

		Assert.assertEquals(product,
		                    productTest);
	}

}
