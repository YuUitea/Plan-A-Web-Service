package com.yuyat.plana.todo.controller;

import com.yuyat.plana.todo.model.Todo;
import com.yuyat.plana.todo.service.TodoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("user/{userName}/todos")
    public List<Todo> getTodosByUserName(@PathVariable String userName) {
        return todoService.findAllByUserName(userName);
    }

    @DeleteMapping("user/{userName}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(
        @PathVariable String userName,
        @PathVariable long id) {
        Optional<Todo> todo = todoService.deleteById(id);
        if (todo.isPresent()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
