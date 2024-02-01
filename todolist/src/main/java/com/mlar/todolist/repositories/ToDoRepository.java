package com.mlar.todolist.repositories;

import com.mlar.todolist.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<ToDo, Long> {


}
