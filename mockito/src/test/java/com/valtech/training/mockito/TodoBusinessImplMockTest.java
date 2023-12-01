package com.valtech.training.mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.valtech.training.data.TodoBusinessImpl;
import com.valtech.training.data.TodoService;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockTest {
	
	@Mock
	TodoService todoServiceMock;

	@Test
	public void test() {

		List<String> todos = Arrays.asList("Kruthik", "Spring", "Spring 1");

		when(todoServiceMock.retrieveTodos("Praveen")).thenReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Praveen");

		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void bddTest() {
		// Given When Then Model

		// Given
//		TodoService todoServiceMock = mock(TodoService.class);

		List<String> todos = Arrays.asList("Kruthik", "Spring", "Spring 1");

		given(todoServiceMock.retrieveTodos("Gagan")).willReturn(todos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

		// When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Gagan");

		// Then
//		assertEquals(2, filteredTodos.size());
		assertThat(filteredTodos.size(), is(2));
	}

}
