package com.training.core.tst.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

	@Test
	public void testListGet() {
		List<String> list = Mockito.mock(List.class);

		Mockito.when(list.get(ArgumentMatchers.anyInt()))
		       .thenReturn("osman");

		String string = list.get(100);

		System.out.println(string);

		String string2 = list.get(-7);

		System.out.println(string2);

	}

}
