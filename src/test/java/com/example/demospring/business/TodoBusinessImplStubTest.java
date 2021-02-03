package com.example.demospring.business;

import com.example.demospring.buisness.TodoBusinessImpl;
import com.example.demospring.stub.TodoServiceStub;
import com.example.demospring.buisnessService.TodoService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("USer");
		assertEquals(2, todos.size());

	}
}
