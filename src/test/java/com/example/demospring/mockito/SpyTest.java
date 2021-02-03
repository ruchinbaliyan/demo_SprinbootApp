package com.example.demospring.mockito;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Junit");
		listSpy.add("Mockito");

		verify(listSpy).add("Junit");
		verify(listSpy).add("Mockito");

		assertEquals(2, listSpy.size());
		assertEquals("Junit", listSpy.get(0));
	}


}