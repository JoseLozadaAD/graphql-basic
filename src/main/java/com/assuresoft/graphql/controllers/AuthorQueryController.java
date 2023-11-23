package com.assuresoft.graphql.controllers;

import com.assuresoft.graphql.model.Author;
import com.assuresoft.graphql.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorQueryController {
  private final AuthorService service;

  @QueryMapping
  public Iterable<Author> findAllAuthors() {
    return service.findAll();
  }

  @QueryMapping
  public Author findAuthorByName(@Argument String name) {
    return service.findByName(name);
  }
}
