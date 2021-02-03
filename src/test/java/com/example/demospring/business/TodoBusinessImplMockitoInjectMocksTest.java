package com.example.demospring.business;

import com.example.demospring.buisness.TodoBusinessImpl;
import com.example.demospring.buisnessService.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	@Mock
	TodoService todoService;

	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;

	@Captor
    ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void usingMockito() {
		List<String> allTodos = Arrays.asList("Learn Spring Boot",
				"Learn Spring", "Learn to Dance","Learn to cook");

		when(todoService.retrieveTodos("User")).thenReturn(allTodos);

		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("User");
		assertEquals(2, todos.size());
	}

	@Test
	public void usingMockito_UsingBDD() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveTodos("User")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("User");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void TestDeleteTodo() {

		List<String> allTodos = Arrays.asList("Learn Spring Boot",
				"Learn Spring", "Learn to Dance","hi");

		when(todoService.retrieveTodos("User")).thenReturn(allTodos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("User");

		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");

		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
		// atLeastOnce, atLeast


	}

	@Test
	public void captureArgument() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		Mockito.when(todoService.retrieveTodos("User")).thenReturn(allTodos);

		todoBusinessImpl.deleteTodosNotRelatedToSpring("User");
		Mockito.verify(todoService).deleteTodo(stringArgumentCaptor.capture());


		assertEquals("Learn to Dance", stringArgumentCaptor.getValue());


	}
}
