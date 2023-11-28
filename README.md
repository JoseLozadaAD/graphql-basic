# graphql-basic
Basic CRUD Graphql project using Spring Boot, Mongo and Java 

## Queries and Mutations
```
query {
  findAllAuthors {
    id
    name
  }
}

query {
  findAllBooks {
    id
    title
  }
}

query {
  findAuthorByName(name: "Some name") {
        id
        name
    		books {
          id
          title
        }
    		createdDate
	}
}

query {
  findBookByTitle(title: "Some name") {
        id
        title
    		publisher
    		createdDate
	}
}

mutation {
  createAuthor(name: "Some name") {
    id
    name
    createdDate
    lastUpdatedDate
  }
}

mutation {
  createBook(title: "Some name", publisher: "Some name") {
    id
    title
    publisher
    createdDate
    lastUpdatedDate
  }
}

mutation {
  addBookToAuthor(authorId: "Id", bookId: "Id") {
    id
    name
    books {
      id
      title
    }
    createdDate
    lastUpdatedDate
  }
}
```
