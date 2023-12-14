package me.hsgamer.springtodolist.repository;

import me.hsgamer.springtodolist.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoItem, Integer> {
    List<ToDoItem> findAllByContentContainingIgnoreCase(String content);
}
