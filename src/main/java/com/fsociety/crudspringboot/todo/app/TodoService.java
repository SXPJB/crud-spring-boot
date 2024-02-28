package com.fsociety.crudspringboot.todo.app;

import com.fsociety.crudspringboot.todo.domain.Todo;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TodoService {
    Todo create(Todo todo);
    Todo update(UUID id, Map<String, Object> data);
    void delete(UUID id);
    Todo findById(UUID id);
    List<Todo> findAll();
}
