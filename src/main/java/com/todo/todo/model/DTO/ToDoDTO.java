package com.todo.todo.model.DTO;

import lombok.Data;

@Data
public class ToDoDTO {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
