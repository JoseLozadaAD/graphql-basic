package com.assuresoft.graphql.repositories;

import com.assuresoft.graphql.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
  Optional<Book> findByTitle(String title);
}
