package com.training.core.tst.management;

import java.util.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.training.core.management.CalculatorOperationManager;
import com.training.core.operations.AddOperation;
import com.training.core.operations.IOperation;
import com.training.core.operations.MultiplyOperation;
import com.training.core.tst.IFailCategory;
import com.training.core.tst.ISuccessCategory;

public class CalculatorOperationManagerTest {

	private CalculatorOperationManager com;

	@Before
	public void setUp() throws Exception {
		this.com = new CalculatorOperationManager();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Category({ ISuccessCategory.class })
	public void testAddOperation() {
		// Test without adding any operation

		// Test with one operation
		AddOperation addOperation = new AddOperation();
		this.com.addOperation(addOperation);
		Iterator<IOperation> operationsItrator = this.com.getOperationsItrator();
		if (!operationsItrator.hasNext()) {
			Assert.fail("Add edilen operasyon alınamadı");
		} else {
			IOperation op = operationsItrator.next();
			Assert.assertEquals(addOperation,
			                    op);
		}

		// Test with multiple operations
		MultiplyOperation multOperation = new MultiplyOperation();
		Iterator<IOperation> operationsItrator2 = this.com.getOperationsItrator();
		int count = 0;
		// ...
	}

	@Test
	@Category({ ISuccessCategory.class })
	public void testGetMenu() {
		AddOperation addOperation = new AddOperation();
		this.com.addOperation(addOperation);
		String menu = this.com.getMenu();
		Assert.assertTrue(menu.startsWith("1-Add"));

	}

	@Test
	@Category({ ISuccessCategory.class })
	public void testExecute() {
		AddOperation addOperation = new AddOperation();
		this.com.addOperation(addOperation);
		MultiplyOperation multOperation = new MultiplyOperation();
		this.com.addOperation(multOperation);
		Assert.assertEquals(20,
		                    this.com.execute(1,
		                                     10,
		                                     10));
		Assert.assertEquals(100,
		                    this.com.execute(2,
		                                     10,
		                                     10));
	}

	@Test(expected = IllegalArgumentException.class)
	@Category({ IFailCategory.class })
	public void testExecuteFail() {
		AddOperation addOperation = new AddOperation();
		this.com.addOperation(addOperation);
		Assert.assertEquals(20,
		                    this.com.execute(2,
		                                     10,
		                                     10));

	}

	@Test(timeout = 10)
	public void testExecutePerformance() {
		AddOperation addOperation = new AddOperation();
		this.com.addOperation(addOperation);
		MultiplyOperation multOperation = new MultiplyOperation();
		this.com.addOperation(multOperation);
		for (int i = 0; i < 10_000; i++) {
			Assert.assertEquals(20,
			                    this.com.execute(1,
			                                     10,
			                                     10));
			Assert.assertEquals(100,
			                    this.com.execute(2,
			                                     10,
			                                     10));

		}
	}

}
