package com.mlar.todolist.model;


import jakarta.persistence.*;
import lombok.Data;


@Data

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;

    public ToDo(String title, String description) {
        this.title = title;
        this.description = description;

    }

    public ToDo() {}
}
