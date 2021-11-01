package com.yuyat.plana.todo.model;

import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo {
    @EqualsAndHashCode.Include
    private final long id;
    private final String userName;
    private String description;
    private Date targetDate;
    private boolean isCompleted;
}
