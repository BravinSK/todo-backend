package com.todo.todo.service;

import com.todo.todo.model.DTO.ToDoDTO;

import java.util.List;

public interface ToDoService {
    List<ToDoDTO> getAllToDos();
    ToDoDTO getToDoById(Long id);
    ToDoDTO createToDo(ToDoDTO toDoCreateDTO);
    ToDoDTO updateToDo(Long id, ToDoDTO toDoDTO);
    void deleteToDoById(Long id);
    void markTaskAsComplete(Long id);
    void markTaskAsIncomplete(Long id);
}
