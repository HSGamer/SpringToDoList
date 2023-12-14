package me.hsgamer.springtodolist.controller;

import me.hsgamer.springtodolist.entity.ToDoItem;
import me.hsgamer.springtodolist.model.ToDoRequest;
import me.hsgamer.springtodolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoController {
    private final ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("items", repository.findAll());
        return "todo";
    }

    @GetMapping("/search")
    public String search(Model model, ToDoRequest toDoRequest) {
        model.addAttribute("items", repository.findAllByContentContainingIgnoreCase(toDoRequest.getContent()));
        return "todo";
    }

    @PostMapping("/create")
    public String create(ToDoRequest toDoRequest) {
        ToDoItem item = new ToDoItem();
        item.setContent(toDoRequest.getContent());
        repository.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/";
    }
}
