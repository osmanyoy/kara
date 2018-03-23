package com.training.spring.jpa;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AdresConvert implements AttributeConverter<Adres, String>{

	@Override
	public String convertToDatabaseColumn(Adres attribute) {
		return attribute.getStreet() + "," + attribute.getTown() + "," + attribute.getCity();
	}

	@Override
	public Adres convertToEntityAttribute(String dbData) {
		String[] split = dbData.split(",");
		Adres adres = new Adres();
		adres.setStreet(split[0]);
		adres.setTown(split[1]);
		adres.setCity(split[2]);
		
		return adres;
	}
	
}
