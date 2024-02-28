package com.fsociety.crudspringboot.todo.domain;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum TodoStatus {
    CREATED(0, "Created"),
    IN_PROGRESS(1, "In Progress"),
    DONE(2, "Done");
    private final int id;
    private final String name;

    private TodoStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<String, TodoStatus> NAME_TO_STATUS = Stream.of(TodoStatus.values())
            .collect(Collectors.toMap(TodoStatus::getName, status -> status));

    public static TodoStatus findByName(String name) {
        return NAME_TO_STATUS.get(name);
    }

}
