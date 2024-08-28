package com.senura.content_calendar.repository;

import com.senura.content_calendar.model.Content;
import com.senura.content_calendar.model.Status;
import com.senura.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional <Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    public void init(){
        Content c = new Content(1,"my first blog post", "my blog post", Status.IDEA, Type.ARTICLE,
                LocalDateTime.now(), null, "");
        Content c1 = new Content(2,"my first blog post 02", "my blog post", Status.IDEA, Type.ARTICLE,
                LocalDateTime.now(), null, "");

        contentList.add(c);
        contentList.add(c1);
    }
}
