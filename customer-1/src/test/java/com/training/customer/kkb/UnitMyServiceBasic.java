package com.training.customer.kkb;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;


public class UnitMyServiceBasic {
	
	private MyService mservice;
	
	@Before
	public void bf() {
		mservice = Mockito.spy(MyService.class);
		MyObject myObject = new MyObject();
		myObject.setName("test");
		myObject.setSurname("sur");
		Mockito.when(mservice.getMyObject(1)).thenReturn(myObject);
		System.out.println("Before");
	}
	
	@After
	public void af() {
		System.out.println("After");
	}
	
	
	@Test
	public void MyService_GetMyObject_Success() {
		MyObject myObject = mservice.getMyObject(1);
		MyObject myObject2 = mservice.getMyObject2();
		System.out.println("out : " + myObject2);
		Assertions.assertThat(myObject.getName()).isEqualTo("osman");
		Assertions.assertThat(myObject.getSurname()).isEqualTo("yaya");
		System.out.println("Test");
	}

	@Test
	public void MyService_GetMyObject_Failure() {
		MyObject myObject = mservice.getMyObject(1);
		Assertions.assertThat(myObject.getName()).isEqualTo("osman");
		Assertions.assertThat(myObject.getSurname()).isNotEqualTo("maya");
		System.out.println("Test");
	}

}
