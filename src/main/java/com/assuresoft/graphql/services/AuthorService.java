package com.assuresoft.graphql.services;

import com.assuresoft.graphql.model.Author;
import com.assuresoft.graphql.model.Book;
import com.assuresoft.graphql.repositories.AuthorRepository;
import com.assuresoft.graphql.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public Author findByName(String name) {
    final Optional<Author> authorFromDb = authorRepository.findByName(name);

    if (authorFromDb.isEmpty()) {
      return null;
    }

    return authorFromDb.get();
  }

  public Iterable<Author> findAll() {
    return authorRepository.findAll();
  }

  public Author create(String name) {
    final Author authorToCreate = new Author();
    final Date date = new Date();

    authorToCreate.setName(name);
    authorToCreate.setCreatedDate(date.toString());
    authorToCreate.setLastUpdatedDate(date.toString());

    return authorRepository.save(authorToCreate);
  }

  public Author addBookToAuthor(String authorId, String bookId) {
    final Optional<Author> authorFromDb = authorRepository.findById(authorId);
    final Optional<Book> bookFromDb = bookRepository.findById(bookId);

    if (authorFromDb.isEmpty() || bookFromDb.isEmpty()) {
      return null;
    }

    final Author authorToUpdate = authorFromDb.get();
    final List<Book> bookList = new ArrayList<>();
    bookList.add(bookFromDb.get());

    if (authorToUpdate.getBooks() != null) {
      bookList.addAll(authorToUpdate.getBooks());
    }

    authorToUpdate.setBooks(bookList);

    return authorRepository.save(authorToUpdate);
  }
}
