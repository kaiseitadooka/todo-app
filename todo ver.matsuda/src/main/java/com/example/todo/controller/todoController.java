package com.example.todo.controller;

import com.example.todo.service.todoService;
import com.example.todo.model.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class todoController {
     private final todoService service;

    public todoController(todoService service){
        this.service =service;
    }

    @GetMapping("/")
    public String index(Model model){
        List<todo> todos = service.getAlltodos();
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/post")
    public String post(@RequestParam String name,
                       @RequestParam String text,
                       @RequestParam(name = "isCompleted", required = false, defaultValue = "false") boolean isCompleted,
                       Model model) {
        if(name.isBlank() || text.isBlank()){
            model.addAttribute("error", "内容の入力は必須です");

        }else{
            service.addtodo(name, text,isCompleted);
        }
        
        List<todo> todos = service.getAlltodos();
        model.addAttribute("todos", todos);
        return "index";
        }

    
        @GetMapping("/delete/{id}")
        public String delete(@PathVariable Integer id, Model model) {
        service.deletetodo(id);
        return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String editForm(@PathVariable Integer id, Model model) {
            todo item = service.gettodoById(id);
            model.addAttribute("todo", item);
            return "edit";
        }

        @PostMapping("/update")
        public String update(@RequestParam Integer id,
                            @RequestParam String name,
                            @RequestParam String text,
                            @RequestParam(name = "isCompleted", required = false, defaultValue = "false") boolean isCompleted,
                            Model model) {
            service.updatetodo(id, name, text, isCompleted);
            return "redirect:/";
                
        }
    }
