package com.yuyat.plana.todo.service;

import com.google.common.collect.Lists;
import com.yuyat.plana.todo.model.Todo;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoService {

    private static List<Todo> TODOS = Lists.newArrayList(
        Todo.builder()
            .id(1)
            .userName("yuyat")
            .description("Learn React")
            .targetDate(new Date())
            .isCompleted(false)
            .build(),
        Todo.builder()
            .id(2)
            .userName("yuyat")
            .description("Vacation in Hawaii")
            .targetDate(new Date())
            .isCompleted(false)
            .build()
    );

    public List<Todo> findAllByUserName(final String userName) {
        //TODO: Update after JPA is implemented
        return TODOS;
    }

    public Optional<Todo> findById(final long id) {
        return TODOS.stream()
            .filter(todo -> id == todo.getId())
            .findFirst();
    }

    public Optional<Todo> deleteById(final long id) {
        Optional<Todo> todo = findById(id);
        todo.ifPresent(TODOS::remove);
        return todo;
    }
}
