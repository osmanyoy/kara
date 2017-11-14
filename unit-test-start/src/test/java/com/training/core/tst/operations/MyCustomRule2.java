package com.training.core.tst.operations;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

public class MyCustomRule2 implements MethodRule {

	public static Map<String, String> connectionPoolDataSource = new HashMap<>();

	public String getConnection(final String name) {
		return MyCustomRule2.connectionPoolDataSource.get(name);
	}

	@Override
	public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
		DBConnection annotation = method.getAnnotation(DBConnection.class);
		if (!MyCustomRule2.connectionPoolDataSource.containsKey(annotation.dbname())) {
			System.out.println("Connecting : " + annotation.dbname());
			MyCustomRule2.connectionPoolDataSource.put(annotation.dbname(),
			                                           annotation.dbname());
		}

		Field[] declaredFields = target.getClass()
		                               .getDeclaredFields();
		for (Field field : declaredFields) {
			InjectConnection injectConnection = field.getAnnotation(InjectConnection.class);
			if (injectConnection != null) {
				try {
					field.set(target,
					          MyCustomRule2.connectionPoolDataSource.get(injectConnection.name()));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				System.out.println("Rule 2 point 1 : DbConnection : " + annotation.dbname());
				base.evaluate();
				System.out.println("Rule 2 point 2");
			}
		};
	}

}
