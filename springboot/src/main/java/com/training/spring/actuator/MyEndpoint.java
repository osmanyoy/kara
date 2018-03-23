package com.training.spring.actuator;

import java.util.Collection;

import org.springframework.boot.actuate.endpoint.EndpointsSupplier;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import com.training.spring.jpa.Adres;

@Endpoint(id="testendpoint")
@Component
public class MyEndpoint {
	
	@ReadOperation
	public Adres getAdres() {
		Adres adres = new Adres();
		adres.setCity("istanbul");
		adres.setStreet("ataşehir");
		adres.setTown("ata");
		return adres;
	}
	
	@ReadOperation
	public Adres getAdres2(@Selector String town) {
		Adres adres = new Adres();
		adres.setCity("istanbul");
		adres.setStreet("ataşehir");
		adres.setTown(town);
		return adres;
	}

}
