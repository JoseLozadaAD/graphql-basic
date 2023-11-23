package com.assuresoft.graphql.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "books")
public class Book {
  @Id
  private String id;
  private String title;
  private String publisher;
  private String createdDate;
  private String lastUpdatedDate;
}
