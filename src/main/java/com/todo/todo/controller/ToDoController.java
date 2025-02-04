package com.todo.todo.controller;

import com.todo.todo.model.DTO.ToDoDTO;
import com.todo.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:3000")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDoDTO>> getAllToDos() {
        List<ToDoDTO> allToDos = toDoService.getAllToDos();
        return ResponseEntity.ok(allToDos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDTO> getToDoById(@PathVariable Long id) {
        ToDoDTO toDoDTO = toDoService.getToDoById(id);
        return toDoDTO != null ? ResponseEntity.ok(toDoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ToDoDTO> createToDo(@RequestBody ToDoDTO toDoDTO) {
        ToDoDTO createdToDo = toDoService.createToDo(toDoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdToDo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoDTO> updateToDo(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) {
        ToDoDTO updatedToDo = toDoService.updateToDo(id, toDoDTO);
        return updatedToDo != null ? ResponseEntity.ok(updatedToDo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteToDoById(@PathVariable Long id) {
        try {
            toDoService.deleteToDoById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting task");
        }
    }

    @PutMapping("/markComplete/{id}")
    public ResponseEntity<Void> markTaskAsComplete(@PathVariable Long id) {
        toDoService.markTaskAsComplete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/markIncomplete/{id}")
    public ResponseEntity<Void> markTaskAsIncomplete(@PathVariable Long id) {
        toDoService.markTaskAsIncomplete(id);
        return ResponseEntity.ok().build();
    }
}
