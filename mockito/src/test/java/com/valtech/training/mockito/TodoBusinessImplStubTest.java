package com.valtech.training.mockito;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.valtech.training.data.TodoBusinessImpl;
import com.valtech.training.data.TodoService;

public class TodoBusinessImplStubTest {

	@Test
	public void test() {
		TodoService todoServiceStub=new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl=new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos=todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(1, filteredTodos.size());
	}

}
