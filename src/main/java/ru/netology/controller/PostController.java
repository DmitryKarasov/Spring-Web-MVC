package ru.netology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.dto.PostDTO;
import ru.netology.exception.NotFoundException;
import ru.netology.service.PostService;
import ru.netology.service.ServiceInterface;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final ServiceInterface<PostDTO> service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<PostDTO> all() {
        return service.all();
    }

    @GetMapping("/{id}")
    public PostDTO getById(@PathVariable long id) {
        try {
            return service.getById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(NOT_FOUND, "Post with id " + id + " not found");
        }
    }

    @PostMapping
    public void save(@RequestBody PostDTO post) {
        service.save(post);
    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) {
        try {
            service.getById(id);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(NOT_FOUND, "Post with id " + id + " not found");
        }
        service.removeById(id);
    }
}
