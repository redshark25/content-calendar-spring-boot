package com.senura.content_calendar.repository;

import com.senura.content_calendar.model.Content;
import com.senura.content_calendar.model.Status;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {

    //Derived Query
    List<Content> findAllByTitleContains(String keyword);

    //using query
    @Query
            ("""
    select * from Content where status = :status
""")
    List<Content> listByStatus(@Param("status") Status status);
}
