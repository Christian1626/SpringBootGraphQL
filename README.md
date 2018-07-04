### Dependencies:
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>4.2.0</version>
</dependency>
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphql-java-tools</artifactId>
    <version>5.1.0</version>
</dependency>
```

### Schemas
Describe what data can be queried:
[https://graphql.org/learn/schema/](https://graphql.org/learn/schema/)

### Resolvers

- **GraphQLResolver**: to resolve complex types. For scalar fields, getter and setter methods will be enough. However, for fields with complex types (like author in Book), you have to use Resolver objects to resolve the value of those fields.
Resolver objects implement the interface GraphQLResolver.
- **GraphQLMutationResolver**: to define the operations of the root Mutation type.
- **GraphQLQueryResolver**: to define the operations of the root Query type.
- **GraphQLSubscriptionResolver**: to define the operations of the root Subscription type.

### GRAPHiQL
Depencency: 
```
<dependency>
    <groupId>com.graphql-java</groupId>
    <artifactId>graphiql-spring-boot-starter</artifactId>
    <version>4.2.0</version>
</dependency>
```

Samples of queries:
[documentation](https://graphql.org/learn/queries/)

```
mutation newAuthor {
  newAuthor(
    firstName: "Chris"
    lastName: "Leroy"
  ) {
    id
    firstName
    lastName
  }
}

query findAllAuthors {
	findAllAuthors {
    id
    firstName
    lastName
  }  
}

mutation newBook {
  newBook(
    title: "Coding",
    isbn: "5455753",
    author: 1) {
    id 
    title
    author {
      id
      firstName
      lastName
    }
  }
}

query findAllBooks {
  findAllBooks {
    id
    isbn
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

### URL
[http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp)
 
[http://localhost:8080/graphiql](http://localhost:8080/graphiql)
