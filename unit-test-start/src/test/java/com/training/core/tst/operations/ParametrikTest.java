package com.training.core.tst.operations;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.training.core.Calculator;

@RunWith(Parameterized.class)
public class ParametrikTest {

	private int input1;
	private int input2;
	private int result;

	@Parameters(name = "{index} test : i1:{0} i2: {1} r:{2} ")
	public static List<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1,
		                                        10,
		                                        11 },
		                                      { 10,
		                                        20,
		                                        30 },
		                                      { 20,
		                                        30,
		                                        51 }

		});
	}

	public ParametrikTest(final int input1, final int input2, final int result) {
		this.input1 = input1;
		this.input2 = input2;
		this.result = result;
	}

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
	public void testParametrikCalculatorAdd() {
		Calculator calc = new Calculator();
		Assert.assertEquals(calc.add(this.input1,
		                             this.input2),
		                    this.result);
	}
}
