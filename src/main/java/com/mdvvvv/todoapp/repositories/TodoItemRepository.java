package com.mdvvvv.todoapp.repositories;

import com.mdvvvv.todoapp.models.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {

}
