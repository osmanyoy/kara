package com.training.customer.kkb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	@Autowired
	private MyObjectDAO myObjectDAO;
	
	public MyObject getMyObject(long id) {
		MyObject myObject = myObjectDAO.findById(id).get();
		return myObject;
	}

	public MyObject getMyObject2() {
		MyObject myObject = new MyObject();
		myObject.setName("osman2");
		myObject.setSurname("yaya2");
		return myObject;
	}

}
