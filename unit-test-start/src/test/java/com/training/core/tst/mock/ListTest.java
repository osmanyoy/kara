package com.training.core.tst.mock;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ListTest {

	@Test
	public void testListGet() {
		List<String> list = Mockito.mock(List.class);

		List<String> list2 = Mockito.mock(List.class);

		Mockito.when(list.get(ArgumentMatchers.anyInt()))
		       .thenReturn("osman")
		       .thenReturn("osman1")
		       .thenReturn("osman2");

		Mockito.when(list.size())
		       .thenCallRealMethod();

		Mockito.when(list2.get(ArgumentMatchers.anyInt()))
		       .thenReturn("mehmet")
		       .thenReturn("mehmet1")
		       .thenReturn("mehmet2");

		InOrder inOrder = Mockito.inOrder(list,
		                                  list2);

		String string = list.get(100);

		System.out.println(string);

		String string4 = list2.get(20);

		System.out.println(string4);

		String string2 = list.get(-7);

		System.out.println(string2);

		String string3 = list.get(25);

		System.out.println(string3);

		inOrder.verify(list)
		       .get(100);
		inOrder.verify(list2)
		       .get(20);

	}

}
