package com.training.core.tst.operations;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.training.core.operations.AddOperation;

public class AddOperationTest {

	@InjectConnection(name = "osman")
	public String connection;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	@Rule
	public MyCustomRule cRule = new MyCustomRule();

	@Rule
	public MyCustomRule2 rule2 = new MyCustomRule2();

	public ErrorCollector errorCollector = new ErrorCollector();

	@Test
	@DBConnection(dbname = "osman")
	public void testAddOperationExecute() {
		System.out.println("testAddOperationExecute start : " + this.rule2.getConnection("osman"));
		AddOperation addOperation = new AddOperation();
		this.errorCollector.checkThat(31,
		                              Matchers.equalTo(addOperation.execute(10,
		                                                                    20)));
		this.errorCollector.checkThat(32,
		                              Matchers.is(addOperation.execute(10,
		                                                               20)));
		this.errorCollector.checkThat(33,
		                              Matchers.is(addOperation.execute(10,
		                                                               20)));
		this.errorCollector.checkThat(34,
		                              Matchers.is(addOperation.execute(10,
		                                                               20)));
		Assert.assertEquals(0,
		                    addOperation.execute(0,
		                                         0));
		Assert.assertEquals(20,
		                    addOperation.execute(10,
		                                         10));
		Assert.assertEquals(10,
		                    addOperation.execute(0,
		                                         10));
		System.out.println("testAddOperationExecute end");
	}

	@Test
	@DBConnection(dbname = "mehmet")
	public void testAddOperationExecute2() {
		System.out.println("******  Injection : " + this.connection);
		System.out.println("start : " + this.rule2.getConnection("mehmet"));

	}

	@Test
	@DBConnection(dbname = "mehmet")
	public void testAddOperationExecute3() {
		System.out.println("start 3 : " + this.rule2.getConnection("mehmet"));

	}

	// @Test
	// public void testAddOperationMenu() {
	// AddOperation addOperation = new AddOperation();
	// Assert.assertEquals("Add",
	// addOperation.menuText());
	// }
}
