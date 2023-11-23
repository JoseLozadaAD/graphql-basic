package com.assuresoft.graphql.controllers;

import com.assuresoft.graphql.model.Author;
import com.assuresoft.graphql.services.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AuthorMutationController {
  private final AuthorService service;

  @MutationMapping
  public Author createAuthor(@Argument String name) {
    return service.create(name);
  }

  @MutationMapping
  public Author addBookToAuthor(@Argument String authorId, @Argument String bookId) {
    return service.addBookToAuthor(authorId, bookId);
  }
}
