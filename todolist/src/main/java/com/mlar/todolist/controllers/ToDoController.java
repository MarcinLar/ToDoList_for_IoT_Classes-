package com.mlar.todolist.controllers;

import com.mlar.todolist.commands.ToDoCommand;
import com.mlar.todolist.converters.ToDoCommandToToDo;
import com.mlar.todolist.converters.ToDoToToDoCommand;
import com.mlar.todolist.model.ToDo;
import com.mlar.todolist.repositories.ToDoRepository;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@Controller
public class ToDoController {
    private ToDoRepository toDoRepository;
    private ToDoCommandToToDo todoCommandToToDo;
    private ToDoToToDoCommand toDoToToDoCommand;

    public ToDoController(ToDoRepository toDoRepository, ToDoCommandToToDo todoCommandToToDo, ToDoToToDoCommand toDoToToDoCommand) {
        this.toDoRepository = toDoRepository;
        this.todoCommandToToDo = todoCommandToToDo;
        this.toDoToToDoCommand = toDoToToDoCommand;
    }

    @RequestMapping(value = "todo/list")
    public String getToDo(Model model){
        model.addAttribute("ToDos", toDoRepository.findAll());
        return "todo/list";
    }


    @GetMapping("/todo/new")
    public String newToDo(Model model){
        model.addAttribute("ToDo", new ToDoCommand());
        return "todo/addedit";
    }

    @PostMapping("/todo/")
    public String saveOrUpdate(@ModelAttribute ToDoCommand command ){

            if(command.getId() == null)
            {
                if(command.getTitle() != "")
                {
                    System.out.println("New task in DB");
                    ToDo detachedToDo = todoCommandToToDo.convert(command);
                    toDoRepository.save(detachedToDo);

                    return "redirect:/todo/list";
                    // return "redirect:/todo/" + savedToDo.getId() + "/show";
                }else {
                    System.out.println("no title variable");
                    return "redirect:/todo/new";
                }

            }else
            {
                Optional<ToDo> ToDoOptional = toDoRepository.findById(command.getId());
                    System.out.println("there's such ToDo in DB");
                    if(command.getTitle() != ""){
                        ToDo toDoFromDatabase = ToDoOptional.get();
                        toDoFromDatabase.setTitle(command.getTitle());
                        toDoFromDatabase.setDescription(command.getDescription());
                        toDoRepository.save(toDoFromDatabase);
                        return "redirect:/todo/list";
                    }else {
                        System.out.println("no title variable");
                        return "redirect:/todo/" + ToDoOptional.get().getId() +"/edit";
                    }
                    // return "redirect:/todo/" + toDoFromDatabase.getId() +"/show";


            }


    }

    @RequestMapping("/todo/{id}/edit")
    public String editToDo(Model model, @PathVariable("id") Long id){
        model.addAttribute("ToDo", toDoToToDoCommand.convert(toDoRepository.findById(id).get()));
        return "todo/addedit";
    }


    @RequestMapping("/todo/{id}/show")
    public String getToDoDetails(Model model,@PathVariable("id") Long id)
    {
        model.addAttribute("ToDo", toDoRepository.findById(id).get());
        return "todo/show";
    }
    @RequestMapping("todo/{id}/delete")
    public String deleteToDo(Model model,@PathVariable("id") Long id)
    {
        toDoRepository.deleteById(id);
        return "redirect:/todo/list";

    }
}
