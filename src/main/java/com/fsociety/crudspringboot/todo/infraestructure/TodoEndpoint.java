package com.fsociety.crudspringboot.todo.infraestructure;

import com.fsociety.crudspringboot.todo.app.TodoService;
import com.fsociety.crudspringboot.todo.domain.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoEndpoint {

    private final TodoService todoService;

    public TodoEndpoint(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        return ResponseEntity.ok(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(todoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.create(todo));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable UUID id, @RequestBody Map<String, Object> data) {
        return ResponseEntity.ok(todoService.update(id,data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
