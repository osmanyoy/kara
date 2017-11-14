package com.training.core.tst.operations;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.core.operations.MultiplyOperation;

public class MultiplyOperationTest {

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
		MultiplyOperation multiplyOperation = new MultiplyOperation();
		Assert.assertEquals(200,
		                    multiplyOperation.execute(10,
		                                              20));
		Assert.assertEquals(0,
		                    multiplyOperation.execute(0,
		                                              0));
		Assert.assertEquals(100,
		                    multiplyOperation.execute(10,
		                                              10));
		Assert.assertEquals(0,
		                    multiplyOperation.execute(0,
		                                              10));
	}

	@Test
	public void testAddOperationMenu() {
		MultiplyOperation multiplyOperation = new MultiplyOperation();
		Assert.assertEquals("Multiply",
		                    multiplyOperation.menuText());
	}
}
