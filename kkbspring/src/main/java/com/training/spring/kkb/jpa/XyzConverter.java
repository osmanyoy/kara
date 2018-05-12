package com.training.spring.kkb.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class XyzConverter implements AttributeConverter<Xyz, String>{

	@Override
	public String convertToDatabaseColumn(Xyz attribute) {
		return attribute.getA() +"," + attribute.getB();
	}

	@Override
	public Xyz convertToEntityAttribute(String dbData) {
		String[] split = dbData.split(",");
		Xyz xyz = new Xyz();
		xyz.setA(split[0]);
		xyz.setB(split[1]);
		return xyz;
	}

}
