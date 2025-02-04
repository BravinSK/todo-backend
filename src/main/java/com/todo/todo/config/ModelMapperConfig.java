package com.todo.todo.config;

import com.todo.todo.model.DTO.ToDoCreateDTO;
import com.todo.todo.model.DTO.ToDoDTO;
import com.todo.todo.model.ToDo;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from ToDoCreateDTO to ToDo, skipping the 'id' field
        modelMapper.addMappings(new PropertyMap<ToDoCreateDTO, ToDo>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });

        return modelMapper;
    }
}
