package com.senura.content_calendar.controller;

import com.senura.content_calendar.model.Content;
import com.senura.content_calendar.repository.ContentCollectionRepository;
import com.senura.content_calendar.repository.ContentJdbcTemplateRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {

    /*//we need an instance of ContentCollectionRepository
    // if someone asks for content
    private ContentCollectionRepository repository;

    public ContentController() {
        repository = new ContentCollectionRepository();
    }
*/
    private final ContentCollectionRepository repository;

    private final ContentJdbcTemplateRepository templateRepository;

    public ContentController(ContentCollectionRepository repository, ContentJdbcTemplateRepository templateRepository) {
        this.repository = repository;
        this.templateRepository = templateRepository;
    }

    //make a request and find all the pieces of content in the system
    // empty path because we got the request mapping on the class itself
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id).
                orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable Integer id){
       if(!repository.findById(id).isPresent()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found");
       }
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        if(!repository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found");
        }
        repository.delete(id);
    }

}
