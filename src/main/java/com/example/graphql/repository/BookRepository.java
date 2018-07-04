package com.example.graphql.repository;

import com.example.graphql.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LEROY Christian - Orange / IMT / OLPS / SOFT
 */
public interface BookRepository extends CrudRepository<Book, Long> {

}
