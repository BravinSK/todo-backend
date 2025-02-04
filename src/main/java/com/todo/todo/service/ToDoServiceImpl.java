package com.todo.todo.service;

import com.todo.todo.model.DTO.ToDoDTO;
import com.todo.todo.model.ToDo;
import com.todo.todo.repository.ToDoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ToDoDTO> getAllToDos() {
        return toDoRepository.findAll()
                .stream()
                .map(toDo -> modelMapper.map(toDo, ToDoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ToDoDTO getToDoById(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        return modelMapper.map(toDo, ToDoDTO.class);
    }

    @Override
    public ToDoDTO createToDo(ToDoDTO toDoCreateDTO) {
        ToDo toDo = modelMapper.map(toDoCreateDTO, ToDo.class);
        ToDo savedToDo = toDoRepository.save(toDo);
        return modelMapper.map(savedToDo, ToDoDTO.class);
    }

    @Override
    public ToDoDTO updateToDo(Long id, ToDoDTO toDoDTO) {
        ToDo existingToDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        modelMapper.map(toDoDTO, existingToDo); // Map updated fields
        ToDo updatedToDo = toDoRepository.save(existingToDo);
        return modelMapper.map(updatedToDo, ToDoDTO.class);
    }

    @Override
    public void deleteToDoById(Long id) {
        if (!toDoRepository.existsById(id)) {
            throw new RuntimeException("ToDo not found");
        }
        toDoRepository.deleteById(id);
    }

    @Override
    public void markTaskAsComplete(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setCompleted(true);
        toDoRepository.save(toDo);
    }

    @Override
    public void markTaskAsIncomplete(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(() -> new RuntimeException("ToDo not found"));
        toDo.setCompleted(false);
        toDoRepository.save(toDo);
    }
}
