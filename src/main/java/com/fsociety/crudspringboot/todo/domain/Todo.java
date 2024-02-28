package com.fsociety.crudspringboot.todo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "todo")
@Getter
@Setter
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private TodoStatus status;
}
