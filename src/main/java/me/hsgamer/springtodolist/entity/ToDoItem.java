package me.hsgamer.springtodolist.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
}
