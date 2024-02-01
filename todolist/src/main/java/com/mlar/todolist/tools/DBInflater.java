package com.mlar.todolist.tools;

import com.mlar.todolist.model.ToDo;
import com.mlar.todolist.repositories.ToDoRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DBInflater implements ApplicationListener<ContextRefreshedEvent> {

    private ToDoRepository toDoRepository;

    public DBInflater(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) { initData(); }

    private void   initData(){
        ToDo task = new ToDo("Prepare Presentation for Team Meeting", "Create slides outlining quarterly performance metrics and projections. Include visual aids and key talking points for a comprehensive presentation during tomorrow's team meeting.");
        ToDo task1 = new ToDo("Grocery Shopping", "Milk, eggs, lettuce, burger meat – check the fridge to see if anything's missing");
        toDoRepository.save(task);
        toDoRepository.save(task1);

    }


}
