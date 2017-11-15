package com.training.core.tst.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.training.hello.Employee;
import com.training.hello.HelloManager;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ HelloManager.class })
public class PowerMockConstructor {
	@Test
	public void test() throws Exception {
		HelloManager classUnderTest = PowerMockito.spy(new HelloManager());

		Employee mock = Mockito.mock(Employee.class);

		Mockito.when(mock.calculate())
		       .thenReturn(100)
		       .thenReturn(120);

		PowerMockito.whenNew(Employee.class)
		            .withAnyArguments()
		            .thenReturn(mock);

		classUnderTest.getHelloByLanguage("Turkish");

		Mockito.verify(mock,
		               Mockito.times(2))
		       .calculate();
	}
}
