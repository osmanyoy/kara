package com.training.core.tst.operations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.core.operations.AddOperation;

public class AddOperationTest {

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
	public void testAddOperationExecute() {
		AddOperation addOperation = new AddOperation();
		Assert.assertEquals(30,
		                    addOperation.execute(10,
		                                         20));
		Assert.assertEquals(0,
		                    addOperation.execute(0,
		                                         0));
		Assert.assertEquals(20,
		                    addOperation.execute(10,
		                                         10));
		Assert.assertEquals(10,
		                    addOperation.execute(0,
		                                         10));
	}

	@Test
	public void testAddOperationMenu() {
		AddOperation addOperation = new AddOperation();
		Assert.assertEquals("Add",
		                    addOperation.menuText());
	}
}
