package com.training.spring.kkb.condition;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context,
	                       AnnotatedTypeMetadata metadata) {
		Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionAnno.class.getName());
		String str = (String)annotationAttributes.get("key");
		String property = context.getEnvironment().getProperty("my.pf.test");
		if (property != null) {
			if (property.equals(str)) {
				return true;
			}
		}
		return false;
	}

}
