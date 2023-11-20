package com.valtech.training.mockito;

import java.util.Arrays;
import java.util.List;

import com.valtech.training.data.TodoService;

public class TodoServiceStub implements TodoService{

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Kruthik","Spring","Gagan");
	}

}
