package com.training.core.tst.operations;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MyCustomRule implements TestRule {

	@Override
	public Statement apply(final Statement base, final Description desc) {

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				System.out.println("Rule point 1");
				base.evaluate();
				System.out.println("Rule point 2");
			}
		};
	}

}
