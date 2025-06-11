package com.example.todo.service;

import com.example.todo.model.todo;
import com.example.todo.repository.todoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class todoService {
    private final todoRepository repository;

    public todoService(todoRepository repository){
        this.repository = repository;
    }

    public List<todo> getAlltodos(){
        return repository.findAll();
    }

    public void addtodo(String name, String text, boolean isCompleted){
        repository.save(new todo(name, text, isCompleted));
    }

    public void deletetodo(Integer id) {
        repository.deleteById(id);
    }

    public void updatetodo(Integer id, String name, String text, boolean isCompleted) {
        todo item = repository.findById(id).orElse(null);
        if (item != null) {
            item.setName(name);
            item.setText(text);
            item.setCompleted(isCompleted);
            repository.save(item);
        }
    }

    public todo gettodoById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
