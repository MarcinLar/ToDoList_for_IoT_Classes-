package com.mlar.todolist.converters;

import com.mlar.todolist.commands.ToDoCommand;
import com.mlar.todolist.model.ToDo;
import jakarta.annotation.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToDoToToDoCommand implements Converter<ToDo, ToDoCommand> {

    @Synchronized
    @Nullable
    @Override

    public ToDoCommand convert(ToDo source){
        final ToDoCommand command = new ToDoCommand();
        command.setId(source.getId());
        command.setTitle(source.getTitle());
        command.setDescription(source.getDescription());

        return command;
    }
}
