package com.training.core.tst.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.training.hello.Hello;
import com.training.hello.HelloManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ HelloManager.class })
public class PowerMockPrivate {
	@Test
	public void test() throws Exception {
		HelloManager classUnderTest = PowerMockito.spy(new HelloManager());
		PowerMockito.when(classUnderTest,
		                  "changeString",
		                  ArgumentMatchers.anyString())
		            .thenReturn("english");
		Hello helloByLanguage = classUnderTest.getHelloByLanguage("osman");

		String helloStr = helloByLanguage.getHelloStr();

		System.out.println("hello : " + helloStr);
		PowerMockito.verifyPrivate(classUnderTest)
		            .invoke("changeString",
		                    "osman");

		Assert.assertEquals("Hello",
		                    helloStr);
	}
}
