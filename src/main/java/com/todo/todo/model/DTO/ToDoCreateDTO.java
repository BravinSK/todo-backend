package com.todo.todo.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoCreateDTO {
    private String title;
    private String description;
    private boolean completed;
}
