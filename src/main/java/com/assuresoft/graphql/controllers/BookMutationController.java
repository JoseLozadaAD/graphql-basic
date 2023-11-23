package com.assuresoft.graphql.controllers;

import com.assuresoft.graphql.model.Book;
import com.assuresoft.graphql.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookMutationController {
  private final BookService service;

  @MutationMapping
  public Book createBook(@Argument String title, @Argument String publisher) {
    return service.create(title, publisher);
  }
}
