package com.senura.content_calendar.repository;

import com.senura.content_calendar.model.Content;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
}
