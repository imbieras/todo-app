package com.mdvvvv.todoapp.services;

import com.mdvvvv.todoapp.models.TodoItem;
import com.mdvvvv.todoapp.repositories.TodoItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm MMMM dd, yyyy z");

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(Instant.now().atZone(ZoneId.systemDefault()).format(formatter));
        }
        todoItem.setUpdatedAt(Instant.now().atZone(ZoneId.systemDefault()).format(formatter));
        return todoItemRepository.save(todoItem);
    }


    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }
}
