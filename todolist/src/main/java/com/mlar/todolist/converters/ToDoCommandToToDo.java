package com.mlar.todolist.converters;

import com.mlar.todolist.commands.ToDoCommand;
import com.mlar.todolist.model.ToDo;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToDoCommandToToDo implements Converter<ToDoCommand, ToDo> {
    @Synchronized
    @Nullable
    @Override
public ToDo convert(ToDoCommand source)
    {
        final ToDo toDo = new ToDo();

        toDo.setTitle(source.getTitle());
        toDo.setDescription(source.getDescription());
        return toDo;

    }


}
