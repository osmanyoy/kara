package com.training.core.tst.hello;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.training.hello.StaticUtility;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ StaticUtility.class })
public class PowerMock {
	@Test
	public void test() {
		PowerMockito.mockStatic(StaticUtility.class);
		PowerMockito.when(StaticUtility.shortVersion(ArgumentMatchers.anyString()))
		            .thenReturn("tr");

		String shortVersion = StaticUtility.shortVersion("English");
		String shortVersion2 = StaticUtility.shortVersion("Turkish");

		PowerMockito.verifyStatic(StaticUtility.class);
		StaticUtility.shortVersion("Turkish");

		Assert.assertEquals("tr",
		                    shortVersion);
	}
}
