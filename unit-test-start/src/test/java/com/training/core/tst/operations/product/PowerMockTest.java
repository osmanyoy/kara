package com.training.core.tst.operations.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.training.core.product.Util;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Util.class })
public class PowerMockTest {
	@Test
	public void test() {
		PowerMockito.mockStatic(Util.class);
		PowerMockito.when(Util.isEmpty(ArgumentMatchers.anyString()))
		            .thenReturn(true);
		boolean empty1 = Util.isEmpty("osman");
		boolean empty2 = Util.isEmpty("");
		System.out.println("Empty1 : " + empty1);
		System.out.println("Empty2 : " + empty2);

		PowerMockito.verifyStatic(Util.class);
		Util.isEmpty("osman1");
	}

}
