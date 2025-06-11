package com.example.todo.model;

import jakarta.persistence.*;

@Entity
public class todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String text;
    private boolean completed;

    public todo() {
    }

    public todo(String name, String text,boolean completed) {
        this.name = name;
        this.text = text;
        this.completed = completed;
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getText(){
        return text;
    }

    public boolean isCompleted() {
    return completed;
    }

    public void setName(String name) {
    this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }


}