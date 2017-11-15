package com.training.core.tst.mock;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

public class ArrayListTest {

	@Test
	public void test() {
		ArrayList<String> strings = new ArrayList<>();
		ArrayList<String> spy = Mockito.spy(strings);

		spy.add("osman");

		Mockito.when(spy.get(0))
		       .thenReturn("mehmet");

		String string = spy.get(0);

		System.out.println("Str : " + string);

		Mockito.verify(spy)
		       .add(ArgumentMatchers.anyString());

	}
}
