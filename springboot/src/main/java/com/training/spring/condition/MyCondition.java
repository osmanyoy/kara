package com.training.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context,
	                       AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> allAnnotationAttributes = metadata.getAllAnnotationAttributes(MyConditionAnno.class.getName());
		String name = (String)allAnnotationAttributes.getFirst("name");
		Integer age = (Integer)allAnnotationAttributes.getFirst("age");
		if (age > 100) {
			return true;
		}
		return false;
	}

}
