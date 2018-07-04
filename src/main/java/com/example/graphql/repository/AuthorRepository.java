package com.example.graphql.repository;

import com.example.graphql.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LEROY Christian - Orange / IMT / OLPS / SOFT
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
