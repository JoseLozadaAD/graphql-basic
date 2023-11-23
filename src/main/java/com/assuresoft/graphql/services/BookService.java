package com.assuresoft.graphql.services;

import com.assuresoft.graphql.model.Author;
import com.assuresoft.graphql.model.Book;
import com.assuresoft.graphql.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
  private final BookRepository repository;

  public Book findByName(String title) {
    final Optional<Book> bookFromDb = repository.findByTitle(title);

    if (bookFromDb.isEmpty()) {
      return null;
    }

    return bookFromDb.get();
  }

  public Iterable<Book> findAll() {
    return repository.findAll();
  }

  public Book create(String title, String publisher) {
    final Book bookToCreate = new Book();
    final Date date = new Date();

    bookToCreate.setTitle(title);
    bookToCreate.setPublisher(publisher);
    bookToCreate.setCreatedDate(date.toString());
    bookToCreate.setLastUpdatedDate(date.toString());

    return repository.save(bookToCreate);
  }
}
