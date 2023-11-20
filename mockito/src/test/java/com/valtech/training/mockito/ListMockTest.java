package com.valtech.training.mockito;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListMockTest {

	@Test
	public void numTest() {
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2,listMock.size());
	}
	
	@Test
	public void stringTest() {
		List listMock=mock(List.class);
		when(listMock.get(0)).thenReturn("Kruthik");
		assertEquals("Kruthik",listMock.get(0));
		assertEquals(null,listMock.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void throwsTest() {
		List listMock=mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Not so Cool"));
		listMock.get(0);
	}


}
