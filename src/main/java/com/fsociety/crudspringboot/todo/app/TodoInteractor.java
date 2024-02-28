package com.fsociety.crudspringboot.todo.app;

import com.fsociety.crudspringboot.todo.domain.Todo;
import com.fsociety.crudspringboot.todo.domain.TodoRepository;
import com.fsociety.crudspringboot.todo.domain.TodoStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoInteractor implements TodoService {

    private final TodoRepository todoRepository;

    public TodoInteractor(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo update(UUID id, Map<String, Object> data) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isEmpty()) {
            return null;
        }

        Todo todo = todoOptional.get();
        if (data.containsKey("title")) {
            todo.setTitle((String) data.get("title"));
        }
        if (data.containsKey("description")) {
            todo.setDescription((String) data.get("description"));
        }
        if (data.containsKey("status")) {
            String status = (String) data.get("status");
            todo.setStatus(TodoStatus.findByName(status));
        }
        return todoRepository.save(todo);

    }

    @Override
    public void delete(UUID id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo findById(UUID id) {
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}
