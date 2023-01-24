package com.mdvvvv.todoapp.repositories;

import com.mdvvvv.todoapp.models.TodoItem;
import org.springframework.data.repository.CrudRepository;

public interface TodoItemRepository extends CrudRepository<TodoItem, Long> {

}
