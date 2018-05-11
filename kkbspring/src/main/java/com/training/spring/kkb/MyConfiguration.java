package com.training.spring.kkb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.training.spring.kkb.property.MyProperties;

import d.e.f.OtherConfig;

@Configuration
@PropertySource("classpath:my.properties")
@ImportResource("mybean.xml")
@Import(OtherConfig.class)
public class MyConfiguration {

	@Bean
	@Qualifier("ahmet")
	public IMyInter createMyInter() {
		return new MyImpl1();
	}

	@Bean
	@Qualifier("mehmet")
	public IMyInter createMyInter2() {
		return new MyImpl1();
	}

	@Bean
	@Qualifier("veli")
	public IMyInter createMyInter3(@Value("${a.b.c}") int index) {
		switch (index) {
		case 1:
			return new MyImpl1();
		case 2:
			return new MyImpl2();
		case 3:
			return new MyImpl3();

		default:
			return new MyImpl1();
		}
	}

	@Scope("prototype")
	@Bean
	@Qualifier("ali")
	public IMyInter createMyInter4(@Value("#{myBean.getIndex2()}") int index) {
		switch (index) {
		case 1:
			return new MyImpl1();
		case 2:
			return new MyImpl2();
		case 3:
			return new MyImpl3();

		default:
			return new MyImpl1();
		}
	}
	
	@Autowired
	public void testMethodWire(@Qualifier("veli") IMyInter inter) {
		System.out.println(inter.execute());
	}

	@Bean
	public MyAutoTest autoTest() {
		return new MyAutoTest();
	}
	
	@Bean
	public MyAutoTest2 autoTest(@Qualifier("veli") IMyInter inter,
	     	                   MyBean bean) {
		return new MyAutoTest2(inter,bean);
	}
	
	@Bean
	public MyProperties readProp() {
		return new MyProperties();
	}
	
	

}
