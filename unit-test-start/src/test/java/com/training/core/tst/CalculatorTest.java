package com.training.core.tst;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.training.core.Calculator;

public class CalculatorTest {

	private Calculator calculator;

	public CalculatorTest() {
		System.out.println("Constructor");
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
		this.calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Test
	public void testCalculatorMultiplyOperationMultiple() {
		System.out.println("Test1");
		int result = this.calculator.multiply(10,
		                                      5);
		Assert.assertEquals(50,
		                    result);
		Assert.assertEquals(10,
		                    this.calculator.multiply(10,
		                                             1));

		Assert.assertEquals(0,
		                    this.calculator.multiply(0,
		                                             10));
	}

	@Test
	public void testCalculatorAddOperationMultiple() {
		System.out.println("Test2");
		int result = this.calculator.add(10,
		                                 5);
		Assert.assertEquals(15,
		                    result);

		Assert.assertEquals(13,
		                    this.calculator.add(10,
		                                        3));

		Assert.assertEquals(0,
		                    this.calculator.add(2,
		                                        -2));
		Assert.assertEquals(-2,
		                    this.calculator.add(0,
		                                        -2));
	}
}
