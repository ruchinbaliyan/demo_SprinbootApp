package com.example.demospring.buisnessService;

import java.util.List;

// some external todoservice
public interface TodoService {

     List<String> retrieveTodos(String user);

    void deleteTodo(String todo);

}