package com.assuresoft.graphql.controllers;

import com.assuresoft.graphql.model.Book;
import com.assuresoft.graphql.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class BookQueryController {
  private final BookService service;

  @QueryMapping
  public Iterable<Book> findAllBooks() {
    return service.findAll();
  }

  @QueryMapping
  public Book findBookByTitle(@Argument String title) {
    return service.findByName(title);
  }
}
