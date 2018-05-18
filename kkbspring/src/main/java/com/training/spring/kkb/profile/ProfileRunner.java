package com.training.spring.kkb.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
@Component
public class ProfileRunner implements CommandLineRunner{

	@Autowired
	private Environment env;
	
	@Autowired	
	private IProfileTest pt;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(pt.execute());
		System.out.println(env.getProperty("my.pf.test"));
	}

}
