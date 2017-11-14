package com.training.core.tst.operations;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AracTestWithTheory {

	@DataPoints
	public static int[] data() {
		return new int[] { -1,
		                   10,
		                   20,
		                   30 };
	}

	@Theory
	public void test(final int value) {
		System.out.println("First Value : " + value);
		Assume.assumeTrue(value > 0);
		System.out.println("Value : " + value);
		Assert.assertTrue(value > 0);

	}

	@Theory
	public void test2(final int value) {
		Assume.assumeTrue(value < 0);
		System.out.println("Value : " + value);
		Assert.assertTrue(value < 0);

	}

}
