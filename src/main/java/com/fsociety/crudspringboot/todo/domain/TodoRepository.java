package com.fsociety.crudspringboot.todo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {
}
