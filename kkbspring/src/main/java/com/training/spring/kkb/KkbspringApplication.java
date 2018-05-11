package com.training.spring.kkb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(scanBasePackages= {"com.training.spring.kkb","d.e.f"})
@SpringBootApplication
@EnableConfigurationProperties
public class KkbspringApplication implements ApplicationRunner{
	
	@Autowired
	@Qualifier("xyz")
	private IMyInter myImpl2;

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(KkbspringApplication.class, args);
		
		KkbspringApplication bean = context.getBean(KkbspringApplication.class);
		System.out.println(bean.getMyInter());
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(getMyInter().execute());
		
	}

	public IMyInter getMyInter() {
		return myImpl2;
	}

	public void setMyInter(IMyInter myInter) {
		this.myImpl2 = myInter;
	}
}
