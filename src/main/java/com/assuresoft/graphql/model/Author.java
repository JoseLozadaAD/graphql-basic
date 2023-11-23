package com.assuresoft.graphql.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "authors")
public class Author {
  @Id
  private String id;
  private String name;
  @DBRef
  private List<Book> books;
  private String createdDate;
  private String lastUpdatedDate;
}
