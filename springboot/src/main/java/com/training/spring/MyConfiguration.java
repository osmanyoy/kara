package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.test.ConfSecond;
import com.test.MyImpl3;
import com.training.spring.properties.KKBProperties;

@Configuration
@PropertySource("classpath:my.properties")
@EnableConfigurationProperties
@Import(ConfSecond.class)
@ImportResource("classpath:abc.xml")
public class MyConfiguration {
	
	private ApplicationContext context;
	
	@Autowired
	public MyConfiguration(ApplicationContext context) {
		// Code
		this.context = context;
	}
	
	@Bean
	public KKBProperties createProperties() {
		return new KKBProperties();
	}
	
	@Autowired
	public void testKKBProperties(KKBProperties kkbProperties) {
		System.out.println(kkbProperties);
	}

	@Bean("test1")
	@Qualifier("ali")
	@Lazy
	public IMyInt createMyInt() {
		MyImpl1 impl1 = new MyImpl1();
		
		return impl1;
	}
	
	@Bean
	@Qualifier("veli")
	public IMyInt createMyInt2(TestComponent testComponent) {
		MyImpl3 impl3 = new MyImpl3();
		impl3.setStr(testComponent.getTestStr());
		impl3.setStr(testComp().getTestStr());
		return impl3;
	}
	
	@Bean
	@Qualifier("orhan")
	public IMyInt createMyInt3() {
		MyImpl3 impl3 = new MyImpl3();
		impl3.setStr(testComp().getTestStr());
		return impl3;
	}

	@Bean
	@Qualifier("orhan")
	public IMyInt createMyInt3(@Value("#{sampleCom.method1()}") String str) {
		MyImpl3 impl3 = new MyImpl3();
		impl3.setStr(str);
		return impl3;
	}

	@Bean
	public TestComponent testComp() {
		TestComponent component = new TestComponent();
		return component;
	}
	
	@Autowired
	public void testOneTimeCall(@Value("${kkb.deneme}") String str) {
		System.out.println(str);
	}
	
	@Autowired
	public void testOneTimeCall2(ApplicationContext applicationContext) {
		String str = applicationContext.getEnvironment().getProperty("kkb.deneme");
		System.out.println(str);
	}

	@Autowired
	public void testOneTimeCall3(Environment environment) {
		String str = environment.getProperty("kkb.deneme");
		System.out.println(str);
	}

}
